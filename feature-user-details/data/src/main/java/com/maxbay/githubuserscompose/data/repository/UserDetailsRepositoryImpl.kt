package com.maxbay.githubuserscompose.data.repository

import com.maxbay.githubuserscompose.data.isDifferenceMoreThanHour
import com.maxbay.githubuserscompose.data.mappers.toDomain
import com.maxbay.githubuserscompose.data.mappers.toEntity
import com.maxbay.githubuserscompose.data.network.UserDetailsApi
import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseUserDetailsStorage
import com.maxbay.githubuserscompose.data.storage.preferences.PreferencesUserDetailsStorage
import com.maxbay.githubuserscompose.domain.models.UserDetails
import com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository
import retrofit2.HttpException

class UserDetailsRepositoryImpl(
    private val userDetailsApi: UserDetailsApi,
    private val databaseStorage: DatabaseUserDetailsStorage,
    private val preferencesStorage: PreferencesUserDetailsStorage
): UserDetailsRepository {
    override suspend fun getUserDetailsById(id: Int): UserDetails {
        val currentTime = System.currentTimeMillis()
        val lastTimeCache = preferencesStorage.getLastTimeCache(userId = id)
        val isNeedGettingFromNetwork = isDifferenceMoreThanHour(
            startTime = lastTimeCache,
            endTime = currentTime
        )

        val users = if (isNeedGettingFromNetwork) {
            try {
                val userDetailsNetwork = userDetailsApi.getUserDetailsById(id = id)
                val userDetailsEntity = userDetailsNetwork.toEntity()

                databaseStorage.addUserDetails(userDetails = userDetailsEntity)
                preferencesStorage.saveLastTimeCache(userId = id, time = currentTime)

                userDetailsNetwork.toDomain()
            }catch (e: HttpException) {
                databaseStorage.getUserDetailsById(id = id).toDomain()
            }
        }else {
            databaseStorage.getUserDetailsById(id = id).toDomain()
        }

        return users
    }
}