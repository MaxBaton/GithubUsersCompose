package com.maxbay.githubuserscompose.domain.models

data class User(
    val avatarUrl: String,
    val id: Int,
    val login: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val siteAdmin: Boolean,
    val url: String
)