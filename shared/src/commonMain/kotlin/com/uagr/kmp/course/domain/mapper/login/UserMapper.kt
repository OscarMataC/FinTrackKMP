package com.uagr.kmp.course.domain.mapper.login

import com.uagr.kmp.course.data.network.model.response.login.UserResponse
import com.uagr.kmp.course.domain.model.login.UserModel

fun UserResponse.toDomain(): UserModel =
    UserModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        email = email.orEmpty(),
        currency = currency.orEmpty(),
        timezone = timezone.orEmpty(),
        locale = locale.orEmpty(),
        isActive = isActive ?: false,
        emailVerified = emailVerified ?: false,
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty()
    )