package com.uagr.kmp.course.domain.usecase.summary

import com.uagr.kmp.course.data.network.model.request.summary.SummaryAccountRequest
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel
import com.uagr.kmp.course.domain.repository.summary.SummaryAccountRepository
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

class SummaryAccountUseCase(private val summaryAccountRepository: SummaryAccountRepository) {
    suspend operator fun invoke(
        url: String,
        dataFrom: String?,
        dataTo: String?,
        idAccount: String?
    ): Flow<NetworkResult<SummaryAccountModel>> =
        summaryAccountRepository.getResumeUserAccount(
            url = url,
            summaryAccountRequest = SummaryAccountRequest(
                dataFrom = dataFrom,
                dataTo = dataTo,
                idAccount = idAccount
            )
        )
}