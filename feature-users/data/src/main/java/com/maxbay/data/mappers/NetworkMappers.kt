package com.maxbay.data.mappers

import com.maxbay.data.models.UserDetailsItem
import com.maxbay.data.models.UserItem
import com.maxbay.data.storage.database.entities.UserEntity
import com.maxbay.domain.models.User
import com.maxbay.domain.models.UserDetails

private const val NULL_STR_REPLACEMENT = "-"

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
    login = this.login ?: NULL_STR_REPLACEMENT,
    email = this.email ?: NULL_STR_REPLACEMENT,
    name = this.name ?: NULL_STR_REPLACEMENT,
    location = this.location ?: NULL_STR_REPLACEMENT,
    avatarUrl = this.avatarUrl ?: NULL_STR_REPLACEMENT,
    company = this.company ?: NULL_STR_REPLACEMENT
)

internal fun List<UserItem>.toDomain() = this.map { it.toDomain() }

internal fun List<UserItem>.toEntity() = this.map { it.toEntity() }