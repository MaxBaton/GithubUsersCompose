package com.maxbay.data.network.api

import com.maxbay.data.models.UserItem
import com.maxbay.data.models.Users
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getAllUsers(): List<UserItem>
}