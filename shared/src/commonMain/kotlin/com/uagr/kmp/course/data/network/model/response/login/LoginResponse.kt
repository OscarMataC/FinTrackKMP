package com.uagr.kmp.course.data.network.model.response.login

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("refresh_token")
    val refreshToken: String?,
    @SerialName("token_type")
    val tokenType: String?,
    @SerialName("expires_in")
    val expiresIn: Int?
): BaseResponse()