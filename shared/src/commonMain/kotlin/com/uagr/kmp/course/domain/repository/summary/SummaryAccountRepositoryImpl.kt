package com.uagr.kmp.course.domain.repository.summary

import com.uagr.kmp.course.data.network.datasource.summary.SummaryAccountNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.summary.SummaryAccountRequest
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SummaryAccountRepositoryImpl(
    private val summaryAccountNetworkDataSource: SummaryAccountNetworkDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : SummaryAccountRepository {
    override suspend fun getResumeUserAccount(
        url: String,
        summaryAccountRequest: SummaryAccountRequest
    ): Flow<NetworkResult<SummaryAccountModel>> = flow {
        emit(
            summaryAccountNetworkDataSource.getResumeUserAccount(
                url = url,
                summaryAccountRequest = summaryAccountRequest
            )
        )
    }.flowOn(ioDispatcher)
}