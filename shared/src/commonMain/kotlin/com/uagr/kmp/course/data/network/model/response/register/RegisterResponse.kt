package com.uagr.kmp.course.data.network.model.response.register

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    @SerialName("user")
    val user: UserResponse?,
    @SerialName("tokens")
    val tokens: TokensResponse?
): BaseResponse()

@Serializable
data class UserResponse(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("currency")
    val currency: String?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("locale")
    val locale: String?,
    @SerialName("is_active")
    val isActive: Boolean?,
    @SerialName("email_verified")
    val emailVerified: Boolean?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("updated_at")
    val updatedAt: String?
)

@Serializable
data class TokensResponse(
    @SerialName("access_token")
    val accessToken: String?,
    @SerialName("refresh_token")
    val refreshToken: String?,
    @SerialName("token_type")
    val tokenType: String?,
    @SerialName("expires_in")
    val expiresIn: Int?
)