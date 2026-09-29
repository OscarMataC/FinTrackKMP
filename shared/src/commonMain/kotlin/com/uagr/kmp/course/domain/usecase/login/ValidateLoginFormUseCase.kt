package com.uagr.kmp.course.domain.usecase.login

class ValidateLoginFormUseCase {
    operator fun invoke(email: String, password: String): LoginFieldValidationResult =
        when {
            email.trim().isEmpty() && password.trim().isEmpty() ->
                LoginFieldValidationResult.EmptyFields
            email.trim().isEmpty() -> LoginFieldValidationResult.EmptyEmail
            password.trim().isEmpty() -> LoginFieldValidationResult.EmptyPassword
            else -> LoginFieldValidationResult.FilledFields
        }
}