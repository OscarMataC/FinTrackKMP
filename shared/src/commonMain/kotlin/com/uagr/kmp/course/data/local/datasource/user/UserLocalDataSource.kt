package com.uagr.kmp.course.data.local.datasource.user

import com.uagr.kmp.course.domain.model.login.UserModel

interface UserLocalDataSource {
    suspend fun saveUserToken(token: String)
    suspend fun insertUserAndDelete(user: UserModel)
}