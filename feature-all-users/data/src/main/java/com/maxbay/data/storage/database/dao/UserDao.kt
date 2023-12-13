package com.maxbay.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.data.storage.database.dto.UserDto
import com.maxbay.data.storage.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

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
}