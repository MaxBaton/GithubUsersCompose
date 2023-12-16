package com.maxbay.data.network

import com.maxbay.data.models.UserItem
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getAllUsers(): List<UserItem>
}