package com.maxbay.githubuserscompose.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.githubuserscompose.data.storage.database.dto.UserDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserEntity

@Dao
interface UserDao {
    @Query(
        "select " +
        "${UserEntity.ID} as ${UserDto.ID}, " +
        "${UserEntity.LOGIN} as ${UserDto.LOGIN}, " +
        "${UserEntity.AVATAR_URL} as ${UserDto.AVATAR_URL}, " +
        "${UserEntity.ORGANIZATION_URL} as ${UserDto.ORGANIZATION_URL}, " +
        "${UserEntity.REPOS_URL} as ${UserDto.REPOS_URL}, " +
        "${UserEntity.SITE_ADMIN} as ${UserDto.SITE_ADMIN}, " +
        "${UserEntity.URL} as ${UserDto.URL} " +
        "from ${UserEntity.TABLE_NAME} " +
        "order by ${UserEntity.ID}"
    )
    suspend fun getAllUsers(): List<UserDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllUsers(users: List<UserEntity>)

    @Query(
        "select " +
                "${UserEntity.ID} as ${UserDto.ID}, " +
                "${UserEntity.LOGIN} as ${UserDto.LOGIN}, " +
                "${UserEntity.AVATAR_URL} as ${UserDto.AVATAR_URL}, " +
                "${UserEntity.ORGANIZATION_URL} as ${UserDto.ORGANIZATION_URL}, " +
                "${UserEntity.REPOS_URL} as ${UserDto.REPOS_URL}, " +
                "${UserEntity.SITE_ADMIN} as ${UserDto.SITE_ADMIN}, " +
                "${UserEntity.URL} as ${UserDto.URL} " +
                "from ${UserEntity.TABLE_NAME} " +
                "where upper(${UserEntity.LOGIN}) like upper('%' || :value || '%') " +
                "or ${UserEntity.ID} like upper('%' || :value || '%')"
    )
    suspend fun getUsersByLoginOrId(value: String): List<UserDto>
}