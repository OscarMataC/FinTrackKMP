package com.uagr.kmp.course.domain.usecase.register

sealed class RegisterFieldValidationResult {
    data object EmptyName: RegisterFieldValidationResult()
    data object EmptyEmail: RegisterFieldValidationResult()
    data object EmptyPassword: RegisterFieldValidationResult()
    data object EmptyConfirmPassword: RegisterFieldValidationResult()
    data object FilledFields: RegisterFieldValidationResult()
}