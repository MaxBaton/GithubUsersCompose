package com.maxbay.githubuserscompose.data.mappers

import com.maxbay.githubuserscompose.data.storage.database.dto.UserDetailsDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity
import com.maxbay.githubuserscompose.domain.models.UserDetails

private const val NULL_STR_REPLACEMENT = "-"

internal fun UserDetailsEntity.toDto() = UserDetailsDto(
    id = this.id,
    login = this.login,
    email = this.email,
    name = this.name,
    location = this.location,
    avatarUrl = this.avatarUrl,
    company = this.company
)

internal fun UserDetailsDto.toDomain() = UserDetails(
    id = this.id,
    login = this.login ?: NULL_STR_REPLACEMENT,
    email = this.email ?: NULL_STR_REPLACEMENT,
    name = this.name ?: NULL_STR_REPLACEMENT,
    location = this.location ?: NULL_STR_REPLACEMENT,
    avatarUrl = this.avatarUrl ?: NULL_STR_REPLACEMENT,
    company = this.company ?: NULL_STR_REPLACEMENT
)