package com.uagr.kmp.course.domain.model.base

open class TokensModel(
    open val accessToken: String,
    open val refreshToken: String,
    open val tokenType: String,
    open val expiresIn: Int
)