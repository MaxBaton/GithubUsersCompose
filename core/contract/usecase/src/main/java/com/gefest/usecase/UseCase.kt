package com.gefest.usecase

import kotlinx.coroutines.flow.Flow

interface UseCaseFlowWithoutParams<RESULT> {
    fun execute(): Flow<RESULT>
}