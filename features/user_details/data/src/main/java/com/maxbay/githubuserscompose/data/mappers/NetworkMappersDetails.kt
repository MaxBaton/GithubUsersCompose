package com.maxbay.githubuserscompose.data.mappers

import com.maxbay.githubuserscompose.data.models.UserDetailsItem
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity

private const val NULL_STR_REPLACEMENT = "-"

internal fun UserDetailsItem.toDomain() = com.maxbay.githubuserscompose.domain.models.UserDetails(
    id = this.id,
    login = this.login ?: NULL_STR_REPLACEMENT,
    email = this.email ?: NULL_STR_REPLACEMENT,
    name = this.name ?: NULL_STR_REPLACEMENT,
    location = this.location ?: NULL_STR_REPLACEMENT,
    avatarUrl = this.avatarUrl ?: NULL_STR_REPLACEMENT,
    company = this.company ?: NULL_STR_REPLACEMENT
)

internal fun UserDetailsItem.toEntity() = UserDetailsEntity(
    id = this.id,
    login = this.login,
    email = this.email,
    name = this.name,
    location = this.location,
    avatarUrl = this.avatarUrl,
    company = this.company
)