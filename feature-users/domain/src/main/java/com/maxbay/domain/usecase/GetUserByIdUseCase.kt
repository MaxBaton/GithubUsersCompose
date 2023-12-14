package com.maxbay.domain.usecase

import com.gefest.usecase.UseCaseSuspendWithOneParam
import com.maxbay.domain.models.User
import com.maxbay.domain.repository.UserRepository

class GetUserByIdUseCase(private val repository: UserRepository): UseCaseSuspendWithOneParam<Int, User> {
    override suspend fun execute(param: Int): User {
        return repository.getUserById(userId = param)
    }
}