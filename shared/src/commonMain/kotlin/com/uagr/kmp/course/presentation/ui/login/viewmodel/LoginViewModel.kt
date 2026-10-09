/*
 * LoginViewModel.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.presentation.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.model.base.DialogModel
import com.uagr.kmp.course.domain.model.login.UserModel
import com.uagr.kmp.course.domain.usecase.login.LoginFieldValidationResult
import com.uagr.kmp.course.domain.usecase.login.LoginUseCase
import com.uagr.kmp.course.domain.usecase.login.ValidateLoginFormUseCase
import com.uagr.kmp.course.domain.usecase.user.InsertUserAndDeleteUseCase
import com.uagr.kmp.course.domain.usecase.user.SaveUserTokenUseCase
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.operators.StatusLoading
import course.shared.generated.resources.Res
import course.shared.generated.resources.accept
import course.shared.generated.resources.email_and_password_empty
import course.shared.generated.resources.email_empty
import course.shared.generated.resources.error
import course.shared.generated.resources.password_empty
import course.shared.generated.resources.please_try_again_later
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

class LoginViewModel(
    private val validateLoginFormUseCase: ValidateLoginFormUseCase,
    private val loginUseCase: LoginUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase,
    private val insertUserAndDeleteUseCase: InsertUserAndDeleteUseCase
): ViewModel() {

    private var _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    private var _loginUiEvent = MutableStateFlow<LoginUiEvent>(LoginUiEvent.Idle)
    val loginUiEvent: StateFlow<LoginUiEvent> = _loginUiEvent.asStateFlow()

    fun showInfoDialog() = viewModelScope.launch {
        _loginUiEvent.emit(LoginUiEvent.ShowVersionInfoDialog)
    }

    fun updateEmail(email: String) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(email = email) }
    }

    fun updatePassword(password: String) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(password = password) }
    }

    fun updatePasswordVisible(passwordVisible: Boolean) = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(passwordVisible = passwordVisible) }
    }

    fun resetUiEvent() = viewModelScope.launch {
        _loginUiEvent.emit(LoginUiEvent.Idle)
    }

    fun validateLoginForm(email: String, password: String) = viewModelScope.launch {
        when (validateLoginFormUseCase(
            email = email,
            password = password
        )) {
            is LoginFieldValidationResult.EmptyFields -> {
                showErrorDialog(Res.string.email_and_password_empty)
            }
            is LoginFieldValidationResult.EmptyEmail -> {
                showErrorDialog(Res.string.email_empty)
            }
            is LoginFieldValidationResult.EmptyPassword -> {
                showErrorDialog(Res.string.password_empty)
            }
            is LoginFieldValidationResult.FilledFields -> {
                login(email = email, password = password)
            }
        }
    }

    private fun login(email: String, password: String) = viewModelScope.launch {
        loginUseCase.login(url = NetworkUrl.LOGIN_ENDPOINT, email = email, password = password)
            .onStart {
            showLoader()
            }.catch {
                hideLoaderAndShowGenericErrorDialog()
            }.collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        val accessToken = result.response.accessToken
                        if(accessToken.isNotEmpty()) {
                            saveUserToken(accessToken)
                        } else {
                            hideLoaderAndShowGenericErrorDialog()
                        }
                    }
                    is NetworkResult.Error -> {
                        hideLoaderAndShowGenericErrorDialog()
                    }
                }
            }
    }

    private fun saveUserToken(token: String) = viewModelScope.launch {
        saveUserTokenUseCase(token = token)
            .catch {
                hideLoaderAndShowGenericErrorDialog()
            }.collect {
                getUser()
            }
    }

    private fun getUser() = viewModelScope.launch {
        loginUseCase.getUser(url = NetworkUrl.GET_USER_ENDPOINT)
            .catch {
                hideLoaderAndShowGenericErrorDialog()
            }.collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        insertUserAndDelete(result.response)
                    }
                    is NetworkResult.Error -> {
                        hideLoaderAndShowGenericErrorDialog()
                    }
                }
            }
    }

    private fun insertUserAndDelete(user: UserModel) = viewModelScope.launch {
        insertUserAndDeleteUseCase(user = user)
            .catch {
                hideLoaderAndShowGenericErrorDialog()
            }.collect {
                hideLoader()
                _loginUiEvent.emit(LoginUiEvent.SuccessLogin)
            }
    }

    private suspend fun setErrorDialog(message: String? = null): DialogModel =
        DialogModel(
            title = getString(resource = Res.string.error),
            message = message ?: getString(resource = Res.string.please_try_again_later),
            primaryButtonText = getString(resource = Res.string.accept)
        )

    fun dismissErrorDialog() = viewModelScope.launch {
        _loginUiState.update { state -> state.copy(errorDialog = null) }
    }

    private fun showLoader() {
        _loginUiState.update { state -> state.copy(isLoading = StatusLoading.SHOW_LOADING) }
    }

    private fun hideLoader() {
        _loginUiState.update { state -> state.copy(isLoading = StatusLoading.DISMISS_LOADING) }
    }

    private suspend fun hideLoaderAndShowGenericErrorDialog(message: String? = null) {
        hideLoader()
        _loginUiState.update { state -> state.copy(errorDialog = setErrorDialog(message)) }
    }

    private suspend fun showErrorDialog(message: StringResource) {
        _loginUiState.update { state ->
            state.copy(
                errorDialog = setErrorDialog(
                    message = getString(message)
                )
            )
        }
    }
}