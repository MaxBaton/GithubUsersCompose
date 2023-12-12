package com.maxbay.data.mappers

import com.maxbay.data.models.UserItem
import com.maxbay.data.models.Users
import com.maxbay.domain.models.User

private fun UserItem.toDomain() = User(
    id = this.id,
    avatarUrl = this.avatar_url,
    login = this.login,
    organizationsUrl = this.organizations_url,
    reposUrl = this.repos_url,
    siteAdmin = this.site_admin,
    url = this.url
)

internal fun List<UserItem>.toDomain() = this.map { it.toDomain() }