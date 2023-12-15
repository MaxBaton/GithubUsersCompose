package com.maxbay.domain.usecase

import com.gefest.usecase.UseCaseSuspendWithOneParam
import com.maxbay.domain.models.UserDetails
import com.maxbay.domain.repository.UserRepository

class GetUserDetailsByIdUseCase(private val repository: UserRepository):
    UseCaseSuspendWithOneParam<Int, UserDetails>{
    override suspend fun execute(param: Int): UserDetails {
        return repository.getUserDetailsById(id = param)
    }
}