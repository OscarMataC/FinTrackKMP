package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse(
    val page: Int?,
    val page_size: Int?,
    val total: Int?,
    val pages: Int?
)