package com.maxbay.githubuserscompose.data.network

import com.maxbay.githubuserscompose.data.models.UserItem
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getAllUsers(): List<UserItem>
}