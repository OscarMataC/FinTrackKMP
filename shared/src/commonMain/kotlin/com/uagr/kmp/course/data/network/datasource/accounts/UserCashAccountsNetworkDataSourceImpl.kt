package com.uagr.kmp.course.data.network.datasource.accounts

import com.uagr.kmp.course.data.network.model.request.accounts.CashAccountsRequest
import com.uagr.kmp.course.data.network.model.response.accounts.CashAccountsResponse
import com.uagr.kmp.course.domain.mapper.account.toDomain
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel
import com.uagr.kmp.course.utils.network.NetworkResult
import com.uagr.kmp.course.utils.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserCashAccountsNetworkDataSourceImpl(private val httpClient: HttpClient)
    : UserCashAccountsNetworkDataSource {
    override suspend fun getUserCashAccounts(
        url: String,
        cashAccountsRequest: CashAccountsRequest
    ): NetworkResult<List<CashAccountModel>> =
        safeApiCall(
            apiCall = {
                httpClient.get(urlString = url) {
                    contentType(type = ContentType.Application.Json)
                    url {
                        parameters.append("page", cashAccountsRequest.page.toString())
                        parameters.append("page_size", cashAccountsRequest.pageSize.toString())
                    }
                }
            },
            transform = { data: CashAccountsResponse ->
                data.toDomain()
            }
        )
}