package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.domain.repository.UserRepository

interface AllUsersFeatureDeps {
    val userRepository: UserRepository
}