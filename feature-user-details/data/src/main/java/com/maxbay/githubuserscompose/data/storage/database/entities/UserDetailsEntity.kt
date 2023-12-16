package com.maxbay.githubuserscompose.data.storage.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserDetailsEntity.TABLE_NAME)
data class UserDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,
    @ColumnInfo(name = LOGIN)
    val login: String?,
    @ColumnInfo(name = EMAIL)
    val email: String?,
    @ColumnInfo(name = NAME)
    val name: String?,
    @ColumnInfo(name = LOCATION)
    val location: String?,
    @ColumnInfo(name = AVATAR_URL)
    val avatarUrl: String?,
    @ColumnInfo(name = COMPANY)
    val company: String?
) {
    companion object {
        const val TABLE_NAME = "user_details"
        const val ID = "id"
        const val LOGIN = "login"
        const val EMAIL = "email"
        const val NAME = "name"
        const val LOCATION = "location"
        const val AVATAR_URL = "avatar_url"
        const val COMPANY = "company"
    }
}
