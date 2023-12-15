package com.maxbay.data.network.api

import com.maxbay.data.models.UserDetailsItem
import com.maxbay.data.models.UserItem
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users")
    suspend fun getAllUsers(): List<UserItem>

    @GET("users/{id}")
    suspend fun getUserDetailsById(@Path("id") id: Int): UserDetailsItem
}