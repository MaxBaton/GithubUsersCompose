package com.maxbay.data.storage.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,
    @ColumnInfo(name = LOGIN)
    val login: String,
    @ColumnInfo(name = AVATAR_URL)
    val avatarUrl: String,
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
        const val TABLE_NAME = "users"
        const val ID = "id"
        const val AVATAR_URL = "avatar_url"
        const val LOGIN = "login"
        const val ORGANIZATION_URL = "organization_url"
        const val REPOS_URL = "repos_url"
        const val SITE_ADMIN = "site_admin"
        const val URL = "url"
    }
}
