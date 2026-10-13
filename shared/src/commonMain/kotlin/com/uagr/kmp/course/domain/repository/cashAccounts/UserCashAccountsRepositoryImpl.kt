package com.uagr.kmp.course.domain.repository.cashAccounts

import com.uagr.kmp.course.data.network.datasource.cashAccounts.UserCashAccountsNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.cashAccounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.cashAccount.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserCashAccountsRepositoryImpl(
    private val accountsNetworkDataSource: UserCashAccountsNetworkDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : UserCashAccountsRepository {
    override suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): Flow<NetworkResult<List<CashAccountModel>>> = flow {
        emit(
            accountsNetworkDataSource.getUserCashAccounts(url, cashAccountsRequest)
        )
    }.flowOn(ioDispatcher)
}