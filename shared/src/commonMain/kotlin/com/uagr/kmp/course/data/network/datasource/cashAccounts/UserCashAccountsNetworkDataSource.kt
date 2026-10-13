package com.uagr.kmp.course.data.network.datasource.cashAccounts

import com.uagr.kmp.course.data.network.model.request.cashAccounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.cashAccount.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface UserCashAccountsNetworkDataSource {
    suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): NetworkResult<List<CashAccountModel>>
}