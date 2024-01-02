package com.maxbay.githubuserscompose.domain.usecase

import com.gefest.usecase.UseCaseSuspendWithOneParamWithoutResult
import com.maxbay.githubuserscompose.domain.repository.UserRepository

class SearchUsersUceCase(private val repository: UserRepository): UseCaseSuspendWithOneParamWithoutResult<String> {
    override suspend fun execute(param: String) {
        repository.searchUsers(search = param)
    }
}