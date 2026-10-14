package com.uagr.kmp.course.domain.repository.accounts

import com.uagr.kmp.course.data.network.datasource.accounts.UserCashAccountsNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.accounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel
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