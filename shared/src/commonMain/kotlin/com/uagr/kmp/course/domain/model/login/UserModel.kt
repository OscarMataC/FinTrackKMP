package com.uagr.kmp.course.domain.model.login

data class UserModel(
    val id: String,
    val name: String,
    val email: String,
    val currency: String,
    val timezone: String,
    val locale: String,
    val isActive: Boolean,
    val emailVerified: Boolean,
    val createdAt: String,
    val updatedAt: String
)