package com.uagr.kmp.course.domain.mapper.account

import com.uagr.kmp.course.data.network.model.response.accounts.CashAccountResponse
import com.uagr.kmp.course.data.network.model.response.accounts.CashAccountsResponse
import com.uagr.kmp.course.domain.model.accounts.CashAccountModel

fun CashAccountsResponse.toDomain(): List<CashAccountModel> =
    items?.map { it.toDomain() } ?: emptyList()

fun CashAccountResponse.toDomain() =
    CashAccountModel(
        id = id.orEmpty(),
        name = name.orEmpty(),
        type = type.orEmpty(),
        currency = currency.orEmpty(),
        initialBalance = initial_balance.orEmpty(),
        currentBalance = current_balance.orEmpty(),
        color = color.orEmpty(),
        icon = icon.orEmpty(),
        isActive = is_active ?: false,
        createdAt = created_at.orEmpty(),
        updatedAt = updated_at.orEmpty(),
        version = version ?: 0
    )