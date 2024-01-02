package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository

interface UserDetailsFeatureDeps {
    val userDetailsRepository: UserDetailsRepository
}