package com.uagr.kmp.course.domain.mapper.register

import com.uagr.kmp.course.data.network.model.response.register.RegisterResponse
import com.uagr.kmp.course.domain.model.register.RegisterModel

fun RegisterResponse.toDomain(): RegisterModel =
        RegisterModel(
            accessToken = tokens?.accessToken.orEmpty(),
            refreshToken = tokens?.refreshToken.orEmpty(),
            tokenType = tokens?.tokenType.orEmpty(),
            expiresIn = tokens?.expiresIn ?: 0,
            name = user?.name.orEmpty(),
            email = user?.email.orEmpty()
        )