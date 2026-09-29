package com.uagr.kmp.course.presentation.ui.login.viewmodel

sealed class LoginUiEvent {
    internal data object Idle : LoginUiEvent()
    data object ShowVersionInfoDialog : LoginUiEvent()
    data object SuccessLogin : LoginUiEvent()
}