package com.maxbay.data.mappers

import com.maxbay.data.storage.database.dto.UserDto
import com.maxbay.domain.models.User

private fun UserDto.toDomain() = User(
    id = this.id,
    avatarUrl = this.avatarUrl,
    login = this.login,
    organizationsUrl = this.organizationsUrl,
    reposUrl = this.reposUrl,
    siteAdmin = this.siteAdmin,
    url = this.url
)

internal fun List<UserDto>.toDomain() = this.map { userDto -> userDto.toDomain() }