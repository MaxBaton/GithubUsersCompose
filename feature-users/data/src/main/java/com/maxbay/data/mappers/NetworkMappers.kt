package com.maxbay.data.mappers

import com.maxbay.data.models.UserDetailsItem
import com.maxbay.data.models.UserItem
import com.maxbay.data.storage.database.entities.UserEntity
import com.maxbay.domain.models.User
import com.maxbay.domain.models.UserDetails

private const val EMPTY = ""

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

internal fun UserDetailsItem.toDomain() = UserDetails(
    id = this.id,
    login = this.login ?: EMPTY,
    email = this.email ?: EMPTY,
    name = this.name ?: EMPTY,
    location = this.location ?: EMPTY,
    avatarUrl = this.avatarUrl ?: EMPTY,
    company = this.company ?: EMPTY
)

internal fun List<UserItem>.toDomain() = this.map { it.toDomain() }

internal fun List<UserItem>.toEntity() = this.map { it.toEntity() }