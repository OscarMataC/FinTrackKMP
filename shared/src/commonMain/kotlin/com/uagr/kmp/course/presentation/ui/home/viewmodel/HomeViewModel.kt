package com.uagr.kmp.course.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.usecase.summary.SummaryAccountUseCase
import com.uagr.kmp.course.domain.usecase.user.GetUserUseCase
import com.uagr.kmp.course.utils.constant.NetworkUrl
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val summaryAccountUseCase: SummaryAccountUseCase
): ViewModel() {

    private var _userUiState = MutableStateFlow(UserUiState())
    val userUiState: StateFlow<UserUiState> = _userUiState.asStateFlow()

    private var _balanceUiState = MutableStateFlow(BalanceUiState())
    val balanceUiState: StateFlow<BalanceUiState> = _balanceUiState.asStateFlow()

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

    fun getSummaryUserAccount(idUserAccount: String) = viewModelScope.launch {
        summaryAccountUseCase(
            url = NetworkUrl.SUMMARY_ENDPOINT,
            dataFrom = null,
            dataTo = null,
            idAccount = idUserAccount
        ).catch {

        }.collect { result ->
            when(result) {
                is NetworkResult.Success -> {
                    val income = result.response.income
                    val expenses = result.response.expenses
                    val net = result.response.net
                    _balanceUiState.update {
                        state -> state.copy(income = income, expenses = expenses, net = net)
                    }
                }

                is NetworkResult.Error -> {

                }
            }
        }
    }
}