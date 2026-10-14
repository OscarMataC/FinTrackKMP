package com.uagr.kmp.course.data.network.datasource.accounts

import com.uagr.kmp.course.data.network.model.request.accounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface UserCashAccountsNetworkDataSource {
    suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): NetworkResult<List<CashAccountModel>>
}