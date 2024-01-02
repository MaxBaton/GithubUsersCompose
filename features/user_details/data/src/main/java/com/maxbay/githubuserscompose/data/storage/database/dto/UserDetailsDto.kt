package com.maxbay.githubuserscompose.data.storage.database.dto

import androidx.room.ColumnInfo

data class UserDetailsDto(
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
        const val ID = "id_user_details_dto"
        const val LOGIN = "login_user_details_dto"
        const val EMAIL = "email_user_details_dto"
        const val NAME = "name_user_details_dto"
        const val LOCATION = "location_user_details_dto"
        const val AVATAR_URL = "avatar_url_user_details_dto"
        const val COMPANY = "company_user_details_dto"
    }
}
