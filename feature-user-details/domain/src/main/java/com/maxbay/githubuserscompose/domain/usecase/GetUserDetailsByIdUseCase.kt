package com.maxbay.githubuserscompose.domain.usecase

import com.gefest.usecase.UseCaseSuspendWithOneParam
import com.maxbay.githubuserscompose.domain.models.UserDetails
import com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository

class GetUserDetailsByIdUseCase(private val repository: UserDetailsRepository):
    UseCaseSuspendWithOneParam<Int, UserDetails>{
    override suspend fun execute(param: Int): UserDetails {
        return repository.getUserDetailsById(id = param)
    }
}