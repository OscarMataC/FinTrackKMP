package com.uagr.kmp.course.domain.mapper.user

import com.uagr.kmp.course.data.local.model.user.UserEntity
import com.uagr.kmp.course.data.network.model.response.login.UserResponse
import com.uagr.kmp.course.domain.model.login.UserModel

fun UserResponse.toDomain(): UserModel =
    UserModel(
        uId = id.orEmpty(),
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

fun UserEntity.toDomain(): UserModel =
    UserModel(
        uId = uId,
        email = email,
        name = name,
        currency = currency,
        timezone = timezone,
        locale = locale,
        isActive = isActive,
        emailVerified = emailVerified,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

fun UserModel.toEntity(): UserEntity =
    UserEntity(
        uId = uId,
        email = email,
        name = name,
        currency = currency,
        timezone = timezone,
        locale = locale,
        isActive = isActive,
        emailVerified = emailVerified,
        createdAt = createdAt,
        updatedAt = updatedAt
    )