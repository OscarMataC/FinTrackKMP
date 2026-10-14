package com.uagr.kmp.course.domain.repository.summary

import com.uagr.kmp.course.data.network.model.request.summary.SummaryAccountRequest
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface SummaryAccountRepository {
    suspend fun getResumeUserAccount(
        url: String,
        summaryAccountRequest: SummaryAccountRequest
    ): Flow<NetworkResult<SummaryAccountModel>>
}