package com.gefest.usecase

import kotlinx.coroutines.flow.Flow

interface UseCaseFlowWithoutParams<RESULT> {
    suspend fun execute(): Flow<RESULT>
}