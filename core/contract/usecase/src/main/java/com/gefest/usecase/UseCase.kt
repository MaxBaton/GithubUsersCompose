package com.gefest.usecase

import kotlinx.coroutines.flow.Flow

interface UseCaseFlowWithoutParams<RESULT> {
    suspend fun execute(): Flow<RESULT>
}

interface UseCaseSuspendWithOneParam<PARAM, RESULT> {
    suspend fun execute(param: PARAM): RESULT
}

interface UseCaseSuspendWithOneParamWithoutResult<PARAM> {
    suspend fun execute(param: PARAM)
}