package com.uagr.kmp.course.domain.mapper.login

import com.uagr.kmp.course.data.network.model.response.login.LoginResponse
import com.uagr.kmp.course.domain.model.login.LoginModel

fun LoginResponse.toDomain(): LoginModel =
    LoginModel(
        accessToken = accessToken.orEmpty(),
        refreshToken = refreshToken.orEmpty(),
        tokenType = tokenType.orEmpty(),
        expiresIn = expiresIn ?: 0
    )