package com.uagr.kmp.course.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.usecase.user.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUserUseCase: GetUserUseCase
): ViewModel() {

    private var _userUiState = MutableStateFlow(UserUiState())
    val userUiState: StateFlow<UserUiState> = _userUiState.asStateFlow()

    init {
        getUser()
    }

    fun getUser() = viewModelScope.launch {
        getUserUseCase()
            .catch {
                _userUiState.update { state -> state.copy(userName = "") }
            }.collect { data ->
                val name = data?.name
                name?.let {
                    _userUiState.update { state -> state.copy(userName = it) }
                }
            }
    }
}