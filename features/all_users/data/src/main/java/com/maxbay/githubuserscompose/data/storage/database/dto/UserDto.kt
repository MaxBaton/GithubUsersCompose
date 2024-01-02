package com.maxbay.githubuserscompose.data.storage.database.dto

import androidx.room.ColumnInfo

data class UserDto(
    @ColumnInfo(name = ID)
    val id: Int,
    @ColumnInfo(name = AVATAR_URL)
    val avatarUrl: String,
    @ColumnInfo(name = LOGIN)
    val login: String,
    @ColumnInfo(name = ORGANIZATION_URL)
    val organizationsUrl: String,
    @ColumnInfo(name = REPOS_URL)
    val reposUrl: String,
    @ColumnInfo(name = SITE_ADMIN)
    val siteAdmin: Boolean,
    @ColumnInfo(name = URL)
    val url: String
) {
    companion object {
        const val ID = "id_user_dto"
        const val AVATAR_URL = "avatar_url_user_dto"
        const val LOGIN = "login_user_dto"
        const val ORGANIZATION_URL = "organization_url_user_dto"
        const val REPOS_URL = "repos_url_user_dto"
        const val SITE_ADMIN = "site_admin_user_dto"
        const val URL = "url_user_dto"
    }
}
