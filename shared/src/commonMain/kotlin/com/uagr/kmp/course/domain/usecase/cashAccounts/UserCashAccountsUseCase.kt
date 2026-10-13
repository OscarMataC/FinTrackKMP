package com.uagr.kmp.course.domain.usecase.cashAccounts

import com.uagr.kmp.course.data.network.model.request.cashAccounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.cashAccount.CashAccountModel
import com.uagr.kmp.course.domain.repository.cashAccounts.UserCashAccountsRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

class UserCashAccountsUseCase(private val userCashAccountsRepository: UserCashAccountsRepository) {
    suspend operator fun invoke(
        url: String,
        page: Int,
        pageSize: Int
    ): Flow<NetworkResult<List<CashAccountModel>>> =
        userCashAccountsRepository.getUserCashAccounts(
            url = url,
            cashAccountsRequest = CashAccountsRequest(
                page = page,
                pageSize = pageSize
            )
        )
}