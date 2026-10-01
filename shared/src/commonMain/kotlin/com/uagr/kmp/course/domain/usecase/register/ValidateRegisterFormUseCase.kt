package com.uagr.kmp.course.domain.usecase.register

class ValidateRegisterFormUseCase {
    operator fun invoke(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): RegisterFieldValidationResult =
        when {
            name.trim().isEmpty() -> RegisterFieldValidationResult.EmptyName
            email.trim().isEmpty() -> RegisterFieldValidationResult.EmptyEmail
            password.trim().isEmpty() -> RegisterFieldValidationResult.EmptyEmail
            confirmPassword.trim().isEmpty() -> RegisterFieldValidationResult.EmptyEmail
            else -> RegisterFieldValidationResult.FilledFields
        }
}