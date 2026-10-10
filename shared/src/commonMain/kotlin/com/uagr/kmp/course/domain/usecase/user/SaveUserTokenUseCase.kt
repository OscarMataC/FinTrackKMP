package com.uagr.kmp.course.domain.usecase.user

import com.uagr.kmp.course.domain.repository.user.UserLocalDataRepository
import kotlinx.coroutines.flow.Flow

class SaveUserTokenUseCase(
    private val userLocalDataRepository: UserLocalDataRepository,
) {
    suspend operator fun invoke(token: String): Flow<Unit> =
        userLocalDataRepository.saveUserToken(token = token)
}