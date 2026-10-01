package com.uagr.kmp.course.domain.model.login

import com.uagr.kmp.course.domain.model.base.TokensModel

data class LoginModel(
    override val accessToken: String,
    override val refreshToken: String,
    override val tokenType: String,
    override val expiresIn: Int
) : TokensModel(accessToken, refreshToken, tokenType, expiresIn)