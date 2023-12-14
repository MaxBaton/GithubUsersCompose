package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.mappers.toEntity
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.storage.database.api.DatabaseStorage
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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val preferencesStorage: PreferencesStorage,
    private val databaseStorage: DatabaseStorage,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): UserRepository {
    private val usersState = MutableStateFlow<List<User>>(emptyList())

    override suspend fun observeUsers(): Flow<List<User>> {
        val users = getUsers()
        usersState.update {
            users
        }

        return usersState
    }

    override suspend fun getUserById(userId: Int): User {
        return databaseStorage.getUserById(id = userId).toDomain()
    }

    override suspend fun searchUsers(search: String) {
        val usersDto = databaseStorage.getUsersByLoginOrId(value = search)
        usersState.update {
            usersDto.toDomain()
        }
    }

    private suspend fun getUsers(): List<User> {
        val currentTime = System.currentTimeMillis()
        val lastCacheTime = preferencesStorage.getLastTimeCache()
        val isNeedGettingFromNetwork = isDifferenceMoreThanMinute(
            startTime = lastCacheTime,
            endTime = currentTime
        )

        return if (isNeedGettingFromNetwork) {
            val usersNetwork = userApi.getAllUsers()
            val usersEntity = usersNetwork.toEntity()

            databaseStorage.addAllUsers(users = usersEntity)
            preferencesStorage.saveLastTimeCache(time = currentTime)

            usersNetwork.toDomain()
        }else {
            databaseStorage.getAllUsers().toDomain()
        }
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