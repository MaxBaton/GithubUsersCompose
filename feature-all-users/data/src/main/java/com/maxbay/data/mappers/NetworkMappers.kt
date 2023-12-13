package com.maxbay.data.mappers

import com.maxbay.data.models.UserItem
import com.maxbay.data.storage.database.entities.UserEntity
import com.maxbay.domain.models.User

private fun UserItem.toDomain() = User(
    id = this.id,
    avatarUrl = this.avatarUrl,
    login = this.login,
    organizationsUrl = this.organizationsUrl,
    reposUrl = this.reposUrl,
    siteAdmin = this.siteAdmin,
    url = this.url
)

private fun UserItem.toEntity() = UserEntity(
    id = this.id,
    avatarUrl = this.avatarUrl,
    login = this.login,
    organizationsUrl = this.organizationsUrl,
    reposUrl = this.reposUrl,
    siteAdmin = this.siteAdmin,
    url = this.url
)

internal fun List<UserItem>.toDomain() = this.map { it.toDomain() }

internal fun List<UserItem>.toEntity() = this.map { it.toEntity() }