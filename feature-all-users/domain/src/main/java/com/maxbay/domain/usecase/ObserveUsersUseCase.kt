package com.maxbay.domain.usecase

import com.maxbay.domain.models.User
import com.maxbay.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveUsersUseCase(private val repository: UserRepository) {
    fun execute(): Flow<List<User>> {
        return repository.observeUsers()
    }
}