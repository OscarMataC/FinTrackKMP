package com.uagr.kmp.course.data.network.datasource.summary

import com.uagr.kmp.course.data.network.model.request.summary.SummaryAccountRequest
import com.uagr.kmp.course.data.network.model.response.summary.SummaryAccountResponse
import com.uagr.kmp.course.domain.mapper.summary.toDomain
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class SummaryAccountNetworkDataSourceImpl(private val httpClient: HttpClient) :
    SummaryAccountNetworkDataSource {
    override suspend fun getResumeUserAccount(
        url: String,
        summaryAccountRequest: SummaryAccountRequest
    ): NetworkResult<SummaryAccountModel> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    url {
                        summaryAccountRequest.dataFrom?.let {
                            parameters.append("date_from", it)
                        }

                        summaryAccountRequest.dataTo?.let {
                            parameters.append("date_to", it)
                        }

                        summaryAccountRequest.idAccount?.let {
                            parameters.append("account_id", it)
                        }
                    }
                }
            },
            transform = { data: SummaryAccountResponse ->
                data.toDomain()
            }
        )
}