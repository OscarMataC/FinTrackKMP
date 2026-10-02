package com.uagr.kmp.course.domain.repository.login

import com.uagr.kmp.course.data.network.datasource.login.LoginNetworkDataSource
import com.uagr.kmp.course.data.network.model.request.login.LoginRequest
import com.uagr.kmp.course.domain.model.login.LoginModel
import com.uagr.kmp.course.domain.model.login.UserModel
import com.uagr.kmp.course.utils.network.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginRepositoryImpl(
    private val loginNetworkDataSource: LoginNetworkDataSource,
    private val ioDispatcher: CoroutineDispatcher
): LoginRepository {
    override suspend fun login(
        url: String,
        loginRequest: LoginRequest,
    ): Flow<NetworkResult<LoginModel>> = flow {
        emit(
            loginNetworkDataSource.login(
                url = url,
                loginRequest = loginRequest,
            )
        )
    }.flowOn(context = ioDispatcher)

    override suspend fun getUser(url: String): Flow<NetworkResult<UserModel>> = flow {
        emit(
            loginNetworkDataSource.getUser(url)
        )
    }.flowOn(ioDispatcher)
}