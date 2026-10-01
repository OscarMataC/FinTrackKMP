package com.uagr.kmp.course.presentation.ui.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.ErrorDialogModel
import com.uagr.kmp.course.domain.usecase.register.RegisterFieldValidationResult
import com.uagr.kmp.course.domain.usecase.register.ValidateRegisterFormUseCase
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.email_and_password_empty
import course.shared.generated.resources.error
import course.shared.generated.resources.missing_fields
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString

class RegisterViewModel(
    private val validateRegisterFormUseCase: ValidateRegisterFormUseCase
): ViewModel() {

    private var _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState: StateFlow<RegisterUiState> = _registerUiState.asStateFlow()

    private var _registerUiEvent = MutableStateFlow(RegisterUiEvent.Idle)
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
                _registerUiState.update { state ->
                    state.copy(
                        errorDialog = setErrorDialog(
                            message = getString(Res.string.missing_fields)
                        )
                    )
                }
            }
            RegisterFieldValidationResult.EmptyEmail -> {
                _registerUiState.update { state ->
                    state.copy(
                        errorDialog = setErrorDialog(
                            message = getString(Res.string.missing_fields)
                        )
                    )
                }
            }
            RegisterFieldValidationResult.EmptyPassword -> {
                _registerUiState.update { state ->
                    state.copy(
                        errorDialog = setErrorDialog(
                            message = getString(Res.string.missing_fields)
                        )
                    )
                }
            }
            RegisterFieldValidationResult.EmptyConfirmPassword -> {
                _registerUiState.update { state ->
                    state.copy(
                        errorDialog = setErrorDialog(
                            message = getString(Res.string.missing_fields)
                        )
                    )
                }
            }
            RegisterFieldValidationResult.FilledFields -> {

            }
        }
    }

    private suspend fun setErrorDialog(message: String? = null): ErrorDialogModel =
        ErrorDialogModel(
            title = getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.accept)
        )

    fun dismissErrorDialog() = viewModelScope.launch {
        _registerUiState.update { state -> state.copy(errorDialog = null) }
    }
}