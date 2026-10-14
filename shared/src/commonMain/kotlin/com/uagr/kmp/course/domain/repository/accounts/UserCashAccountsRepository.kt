package com.uagr.kmp.course.domain.repository.accounts

import com.uagr.kmp.course.data.network.model.request.accounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface UserCashAccountsRepository {
    suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): Flow<NetworkResult<List<CashAccountModel>>>
}