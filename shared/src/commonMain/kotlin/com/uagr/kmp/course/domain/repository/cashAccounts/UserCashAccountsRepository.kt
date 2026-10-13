package com.uagr.kmp.course.domain.repository.cashAccounts

import com.uagr.kmp.course.data.network.model.request.cashAccounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.cashAccount.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface UserCashAccountsRepository {
    suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): Flow<NetworkResult<List<CashAccountModel>>>
}