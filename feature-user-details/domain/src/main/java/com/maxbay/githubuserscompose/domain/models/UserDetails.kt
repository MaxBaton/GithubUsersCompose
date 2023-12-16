package com.maxbay.githubuserscompose.domain.models

data class UserDetails(
    val id: Int,
    val login: String,
    val email: String,
    val name: String,
    val location: String,
    val avatarUrl: String,
    val company: String
)