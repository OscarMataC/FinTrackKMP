package com.uagr.kmp.course.domain.mapper.summary

import com.uagr.kmp.course.data.network.model.response.summary.SummaryAccountResponse
import com.uagr.kmp.course.domain.model.summary.SummaryAccountModel

fun SummaryAccountResponse.toDomain(): SummaryAccountModel =
    SummaryAccountModel(
        income = income.orEmpty(),
        expenses = expenses.orEmpty(),
        net = net.orEmpty()
    )