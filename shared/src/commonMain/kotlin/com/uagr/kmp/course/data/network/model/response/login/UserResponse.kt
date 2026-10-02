package com.uagr.kmp.course.data.network.model.response.login

import com.uagr.kmp.course.data.network.model.response.base.BaseResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
): BaseResponse()
