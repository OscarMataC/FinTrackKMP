package com.uagr.kmp.course.data.network.datasource.summary

import com.uagr.kmp.course.data.network.model.request.summary.SummaryAccountRequest
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult

interface SummaryAccountNetworkDataSource {
    suspend fun getResumeUserAccount(
        url: String,
        summaryAccountRequest: SummaryAccountRequest
    ): NetworkResult<SummaryAccountModel>
}