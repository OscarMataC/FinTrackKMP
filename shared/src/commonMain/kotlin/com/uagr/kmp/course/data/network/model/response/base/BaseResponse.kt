/*
 * BaseResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.data.network.model.response.base

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse(
    val error: ErrorDetail? = null
)

@Serializable
data class ErrorDetail(
    val code: String?,
    val message: String?
)