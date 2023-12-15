package com.maxbay.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maxbay.data.storage.database.dao.UserDao
import com.maxbay.data.storage.database.entities.UserEntity

private const val DATABASE_VERSION = 1
private const val DATABASE_NAME = "github_users"

@Database(
    version = DATABASE_VERSION,
    entities = [UserEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

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