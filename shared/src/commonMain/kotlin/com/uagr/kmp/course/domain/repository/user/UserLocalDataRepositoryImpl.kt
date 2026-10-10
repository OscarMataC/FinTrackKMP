package com.uagr.kmp.course.domain.repository.user

import com.uagr.kmp.course.data.local.datasource.user.UserLocalDataSource
import com.uagr.kmp.course.domain.model.login.UserModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserLocalDataRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
): UserLocalDataRepository {
    override suspend fun saveUserToken(token: String): Flow<Unit> = flow {
        emit(userLocalDataSource.saveUserToken(token = token))
    }.flowOn(context = ioDispatcher)

    override suspend fun insertUserAndDelete(user: UserModel): Flow<Unit> = flow {
        emit(userLocalDataSource.insertUserAndDelete(user = user))
    }.flowOn(context = ioDispatcher)

    override suspend fun getUser(): Flow<UserModel?> = flow {
        emit(userLocalDataSource.getUser())
    }.flowOn(context = ioDispatcher)
}