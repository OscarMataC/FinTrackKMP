package com.uagr.kmp.course.domain.repository.user

import com.uagr.kmp.course.data.local.datasource.bone.user.UserLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher
): UserRepository {
    override suspend fun saveUserToken(token: String): Flow<Unit> = flow {
        emit(userLocalDataSource.saveUserToken(token = token))
    }.flowOn(context = ioDispatcher)
}