package com.uagr.kmp.course.presentation.ui.register.viewmodel

import com.uagr.kmp.course.domain.model.base.DialogModel
import com.uagr.kmp.course.utils.operators.StatusLoading

data class RegisterUiState(
    val isLoading: StatusLoading = StatusLoading.DISMISS_LOADING,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isVisiblePassword: Boolean = false,
    val isVisibleConfirmPassword: Boolean = false,
    val errorDialog: DialogModel? = null,
    val dialog: DialogModel? = null
)