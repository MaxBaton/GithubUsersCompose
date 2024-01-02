package com.maxbay.githubuserscompose.data.mappers

import com.maxbay.githubuserscompose.data.storage.database.dto.UserDto
import com.maxbay.githubuserscompose.domain.models.User

internal fun UserDto.toDomain() = com.maxbay.githubuserscompose.domain.models.User(
    id = this.id,
    avatarUrl = this.avatarUrl,
    login = this.login,
    organizationsUrl = this.organizationsUrl,
    reposUrl = this.reposUrl,
    siteAdmin = this.siteAdmin,
    url = this.url
)

internal fun List<UserDto>.toDomain() = this.map { userDto -> userDto.toDomain() }