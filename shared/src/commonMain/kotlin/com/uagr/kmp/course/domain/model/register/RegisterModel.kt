package com.uagr.kmp.course.domain.model.register

import com.uagr.kmp.course.domain.model.base.TokensModel

data class RegisterModel(
    override val accessToken: String,
    override val refreshToken: String,
    override val tokenType: String,
    override val expiresIn: Int,
    val name: String,
    val email: String
): TokensModel(accessToken, refreshToken, tokenType, expiresIn)