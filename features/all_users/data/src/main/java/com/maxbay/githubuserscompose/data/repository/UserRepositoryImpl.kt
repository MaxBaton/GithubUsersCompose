package com.maxbay.githubuserscompose.data.repository

import com.maxbay.githubuserscompose.data.isDifferenceMoreThanHour
import com.maxbay.githubuserscompose.data.mappers.toDomain
import com.maxbay.githubuserscompose.data.mappers.toEntity
import com.maxbay.githubuserscompose.data.network.UserApi
import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage
import com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorage
import com.maxbay.githubuserscompose.domain.models.User
import com.maxbay.githubuserscompose.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.HttpException

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val preferencesStorage: PreferencesStorage,
    private val databaseStorage: DatabaseStorage
): UserRepository {
    private val usersState = MutableStateFlow<List<User>>(emptyList())

    override suspend fun observeUsers(): Flow<List<User>> {
        val users = getUsers()
        usersState.update {
            users
        }

        return usersState
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
        val isNeedGettingFromNetwork = isDifferenceMoreThanHour(
            startTime = lastCacheTime,
            endTime = currentTime
        )

        return if (isNeedGettingFromNetwork) {
            try {
                val usersNetwork = userApi.getAllUsers()
                val usersEntity = usersNetwork.toEntity()

                databaseStorage.addAllUsers(users = usersEntity)
                preferencesStorage.saveLastTimeCache(time = currentTime)

                usersNetwork.toDomain()
            }catch (e: HttpException) {
                databaseStorage.getAllUsers().toDomain()
            }
        }else {
            databaseStorage.getAllUsers().toDomain()
        }
    }
}