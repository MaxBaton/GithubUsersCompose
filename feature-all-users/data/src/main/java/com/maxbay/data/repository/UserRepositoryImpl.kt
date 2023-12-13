package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.models.UserItem
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.network.api.UserApiHelper
import com.maxbay.data.storage.prefrenses.PreferencesStorage
import com.maxbay.data.utils.MILLISECOND_IN_MINUTES_COEFF
import com.maxbay.data.utils.ONE_MINUTE_LONG_VALUE
import com.maxbay.data.utils.ZERO_LONG_VALUE
import com.maxbay.domain.models.User
import com.maxbay.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userApiHelper: UserApiHelper,
    private val preferencesStorage: PreferencesStorage,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): UserRepository {
    override fun observeUsers(): Flow<List<User>> {
        val currentTime = System.currentTimeMillis()
        val lastCacheTime = 0L //preferencesStorage.getLastTimeCache()
        val isNeedGettingFromNetwork = isDifferenceMoreThanMinute(
            startTime = lastCacheTime,
            endTime = currentTime
        )

        val users = if (isNeedGettingFromNetwork) {
             userApiHelper
                .getAllUsers()
                .flowOn(context = dispatcher)
                .map { it.toDomain() }
        }else {
            flowOf(emptyList<UserItem>()).map { it.toDomain() }
        }

        return users
    }

    private fun isDifferenceMoreThanMinute(startTime: Long, endTime: Long): Boolean {
        return if (endTime > ZERO_LONG_VALUE) {
            val diffMilliSeconds = endTime - startTime
            val diffMinutes = diffMilliSeconds / MILLISECOND_IN_MINUTES_COEFF
            diffMinutes >= ONE_MINUTE_LONG_VALUE
        }else {
            true
        }
    }
}