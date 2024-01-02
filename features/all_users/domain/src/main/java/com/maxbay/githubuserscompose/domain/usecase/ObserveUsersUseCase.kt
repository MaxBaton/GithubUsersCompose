package com.maxbay.githubuserscompose.domain.usecase

import com.gefest.usecase.UseCaseFlowWithoutParams
import com.maxbay.githubuserscompose.domain.models.User
import com.maxbay.githubuserscompose.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveUsersUseCase(private val repository: UserRepository):
    UseCaseFlowWithoutParams<List<User>>{
    override suspend fun execute(): Flow<List<User>> {
        return repository.observeUsers()
    }
}