package com.maxbay.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maxbay.githubuserscompose.data.storage.database.dao.UserDao
import com.maxbay.githubuserscompose.data.storage.database.entities.UserEntity
import com.maxbay.githubuserscompose.data.storage.database.dao.UserDetailsDao
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity

private const val DATABASE_VERSION = 2
private const val DATABASE_NAME = "github_users"

@Database(
    version = DATABASE_VERSION,
    entities = [com.maxbay.githubuserscompose.data.storage.database.entities.UserEntity::class, com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity::class],
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): com.maxbay.githubuserscompose.data.storage.database.dao.UserDao
    abstract fun userDetailsDao(): com.maxbay.githubuserscompose.data.storage.database.dao.UserDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun create(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(LOCK) {
                val instance = Room.databaseBuilder(
                    context = context,
                    klass = AppDatabase::class.java,
                    name = DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}