package com.uagr.kmp.course.data.local.datasource.user

import com.uagr.kmp.course.data.local.database.dao.UserDao
import com.uagr.kmp.course.data.local.datastore.AppDataStore
import com.uagr.kmp.course.domain.mapper.user.toEntity
import com.uagr.kmp.course.domain.model.login.UserModel

class UserLocalDataSourceImpl(
    private val appDataStore: AppDataStore,
    private val userDao: UserDao,
): UserLocalDataSource {
    override suspend fun saveUserToken(token: String) {
        appDataStore.saveUserToken(token = token)
    }

    override suspend fun insertUserAndDelete(user: UserModel) {
        userDao.insertUserAndDeleteOld(user = user.toEntity())
    }

    override suspend fun getUser(): UserModel? = userDao.getUser()
}