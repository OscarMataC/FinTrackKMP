package com.uagr.kmp.course.domain.usecase.user

import com.uagr.kmp.course.domain.repository.user.UserRepository
import kotlinx.coroutines.flow.Flow

class SaveUserTokenUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(token: String): Flow<Unit> =
        userRepository.saveUserToken(token = token)
}