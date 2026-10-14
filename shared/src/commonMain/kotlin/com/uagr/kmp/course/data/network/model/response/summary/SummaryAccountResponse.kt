package com.uagr.kmp.course.data.network.model.response.summary

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class SummaryAccountResponse(
    val income: String?,
    val expenses: String?,
    val net: String?
): BaseResponse()