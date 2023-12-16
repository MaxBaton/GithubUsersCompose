package com.maxbay.githubuserscompose.data.network

import com.maxbay.githubuserscompose.data.models.UserDetailsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailsApi {
    @GET("users/{id}")
    suspend fun getUserDetailsById(@Path("id") id: Int): UserDetailsItem
}