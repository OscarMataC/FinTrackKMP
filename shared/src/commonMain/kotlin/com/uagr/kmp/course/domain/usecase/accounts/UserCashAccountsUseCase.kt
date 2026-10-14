package com.uagr.kmp.course.domain.usecase.accounts

import com.uagr.kmp.course.data.network.model.request.accounts.CashAccountsRequest
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel
import com.uagr.kmp.course.domain.repository.accounts.UserCashAccountsRepository
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