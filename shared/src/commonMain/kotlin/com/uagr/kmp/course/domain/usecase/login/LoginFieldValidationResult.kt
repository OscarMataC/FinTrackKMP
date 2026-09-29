package com.uagr.kmp.course.domain.usecase.login

sealed class LoginFieldValidationResult {
    data object EmptyEmail: LoginFieldValidationResult()
    data object EmptyPassword: LoginFieldValidationResult()
    data object EmptyFields: LoginFieldValidationResult()
    data object FilledFields: LoginFieldValidationResult()
}
