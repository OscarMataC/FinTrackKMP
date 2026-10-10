package com.uagr.kmp.course.domain.usecase.user

import com.uagr.kmp.course.domain.model.login.UserModel
import com.uagr.kmp.course.domain.repository.user.UserLocalDataRepository
import kotlinx.coroutines.flow.Flow

class InsertUserAndDeleteUseCase(private val userLocalDataRepository: UserLocalDataRepository) {
    suspend operator fun invoke(user: UserModel): Flow<Unit> =
        userLocalDataRepository.insertUserAndDelete(user = user)
}