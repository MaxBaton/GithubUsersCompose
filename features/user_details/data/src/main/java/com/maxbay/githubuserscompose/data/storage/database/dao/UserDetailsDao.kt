package com.maxbay.githubuserscompose.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maxbay.githubuserscompose.data.storage.database.dto.UserDetailsDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity

@Dao
interface UserDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserDetails(userDetails: UserDetailsEntity)

    @Query(
        "select " +
        "${UserDetailsEntity.ID} as ${UserDetailsDto.ID}, " +
        "${UserDetailsEntity.LOGIN} as ${UserDetailsDto.LOGIN}, " +
        "${UserDetailsEntity.AVATAR_URL} as ${UserDetailsDto.AVATAR_URL}, " +
        "${UserDetailsEntity.COMPANY} as ${UserDetailsDto.COMPANY}, " +
        "${UserDetailsEntity.EMAIL} as ${UserDetailsDto.EMAIL}, " +
        "${UserDetailsEntity.LOCATION} as ${UserDetailsDto.LOCATION}, " +
        "${UserDetailsEntity.NAME} as ${UserDetailsDto.NAME} " +
        "from ${UserDetailsEntity.TABLE_NAME} " +
        "where ${UserDetailsEntity.LOGIN} = :id"
    )
    suspend fun getUserDetailsById(id: Int): UserDetailsDto
}