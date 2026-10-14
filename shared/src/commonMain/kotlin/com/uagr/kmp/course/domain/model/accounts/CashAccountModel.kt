package com.uagr.kmp.course.domain.model.accounts

data class CashAccountModel(
    val id: String,
    val name: String,
    val type: String,
    val currency: String,
    val initialBalance: String,
    val currentBalance: String,
    val color: String,
    val icon: String,
    val isActive: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val version: Int
)