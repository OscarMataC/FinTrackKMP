package com.uagr.kmp.course.data.local.datasource.bone.user

import com.uagr.kmp.course.data.local.datastore.AppDataStore

class UserLocalDataSourceImpl(
    private val appDataStore: AppDataStore
): UserLocalDataSource {
    override suspend fun saveUserToken(token: String) {
        appDataStore.saveUserToken(token = token)
    }
}