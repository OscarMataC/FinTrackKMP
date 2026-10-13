package com.uagr.kmp.course.data.network.model.response.cashAccounts

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import com.uagr.kmp.course.data.network.model.response.base.PaginationResponse
import kotlinx.serialization.Serializable

@Serializable
data class CashAccountsResponse(
    val items: List<CashAccountResponse>?,
    val pagination: PaginationResponse?
): BaseResponse()

@Serializable
data class CashAccountResponse(
    val id: String?,
    val name: String?,
    val type: String?,
    val currency: String?,
    val initial_balance: String?,
    val current_balance: String?,
    val color: String?,
    val icon: String?,
    val is_active: Boolean?,
    val created_at: String?,
    val updated_at: String?,
    val version: Int?
)