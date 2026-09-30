package com.uagr.kmp.course.domain.repository.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUserToken(token: String): Flow<Unit>
}