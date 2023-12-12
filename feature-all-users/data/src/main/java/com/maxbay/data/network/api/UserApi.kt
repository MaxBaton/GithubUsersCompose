package com.maxbay.data.network.api

import com.maxbay.data.models.Users
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getAllUsers(): Flow<Users>
}