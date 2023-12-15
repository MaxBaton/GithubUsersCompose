package com.maxbay.domain.models

data class UserDetails(
    val id: Int,
    val login: String,
    val email: Any,
    val name: String,
    val location: String,
    val avatarUrl: String,
    val company: String
)