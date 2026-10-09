package com.uagr.kmp.course.presentation.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.DialogModel
import com.uagr.kmp.course.domain.usecase.register.RegisterFieldValidationResult
import com.uagr.kmp.course.domain.usecase.register.RegisterUseCase
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormUseCase
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.error
import course.shared.generated.resources.missing_fields
import course.shared.generated.resources.passwords_dont_match
import course.shared.generated.resources.please_try_again_later
import course.shared.generated.resources.successful_register_description
import course.shared.generated.resources.successful_register_title
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

class RegisterViewModel(
    private val validateRegisterFormUseCase: ValidateRegisterFormUseCase,
    private val registerUseCase: RegisterUseCase
): ViewModel() {

    private var _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    private var _registerUiEvent = MutableStateFlow<RegisterUiEvent>(RegisterUiEvent.Idle)
    val registerUiEvent: StateFlow<RegisterUiEvent> = _registerUiEvent.asStateFlow()

    fun updateName(name: String) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(name = name) }
    }

    fun updateEmail(email: String) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(email = email) }
    }

    fun updatePassword(password: String) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(password = password) }
    }

    fun updateIsVisiblePassword(isVisiblePassword: Boolean) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(isVisiblePassword = isVisiblePassword) }
    }

    fun updateConfirmPassword(confirmPassword: String) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(confirmPassword = confirmPassword) }
    }

    fun updateIsVisibleConfirmPassword(isVisibleConfirmPassword: Boolean) = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(isVisibleConfirmPassword = isVisibleConfirmPassword) }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _registerUiEvent.emit(RegisterUiEvent.Idle)
    }

    fun validateRegisterForm(name: String, email: String, password: String, confirmPassword: String)
    = viewModelScope.launch {
        when(validateRegisterFormUseCase(name, email, password, confirmPassword)) {
            RegisterFieldValidationResult.EmptyName -> {
                showErrorDialog(Res.string.missing_fields)
            }
            RegisterFieldValidationResult.EmptyEmail -> {
                showErrorDialog(Res.string.missing_fields)
            }
            RegisterFieldValidationResult.EmptyPassword -> {
                showErrorDialog(Res.string.missing_fields)
            }
            RegisterFieldValidationResult.EmptyConfirmPassword -> {
                showErrorDialog(Res.string.missing_fields)
            }
            RegisterFieldValidationResult.FilledFields -> {
                if(validateSamePassword(password = password, confirmPassword = confirmPassword)) {
                    register(name = name, email = email, password = password)
                } else {
                    showErrorDialog(Res.string.passwords_dont_match)
                }
            }
        }
    }

    private fun validateSamePassword(password: String, confirmPassword: String)
    = password.trim() == confirmPassword.trim()

    private fun register(name: String, email: String, password: String) = viewModelScope.launch {
        registerUseCase(
            url = NetworkUrl.REGISTER_ENDPOINT,
            name = name,
            email = email,
            password = password
        ).onStart {
            showLoader()
        }.catch {
            hideLoaderAndShowGenericErrorDialog()
        }.collect { result ->
            when (result) {
                is NetworkResult.Success -> {
                    hideLoader()
                    _registerUiState.update { state ->
                        state.copy(
                            dialog = setMessageDialog(
                                getString(resource = Res.string.successful_register_title),
                                message = getString(resource = Res.string.successful_register_description)
                            )
                        )
                    }
                    _registerUiEvent.emit(RegisterUiEvent.SuccessfulRegister)
                }
                is NetworkResult.Error -> {
                    hideLoaderAndShowGenericErrorDialog()
                }
            }
        }
    }

    private suspend fun setErrorDialog(message: String? = null): DialogModel =
        DialogModel(
            title = getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.accept)
        )

    private suspend fun setMessageDialog(title: String, message: String): DialogModel =
        DialogModel(
            title = title,
            message = message ,
            primaryButtonText = getString(resource = Res.string.accept)
        )

    fun dismissErrorDialog() = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(errorDialog = null) }
    }

    private fun showLoader() {
        _registerUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
    }

    private fun hideLoader() {
        _registerUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
    }

    private suspend fun hideLoaderAndShowGenericErrorDialog() {
        hideLoader()
        _registerUiState.update { state -> state.copy(errorDialog = setErrorDialog()) }
    }

    private suspend fun showErrorDialog(message: StringResource) {
        _registerUiState.update { state ->
            state.copy(errorDialog = setErrorDialog(message = getString(message)))
        }
    }
}