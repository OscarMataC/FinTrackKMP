package com.uagr.kmp.course.data.local.datasource.bone.user

interface UserLocalDataSource {
    suspend fun saveUserToken(token: String)
}