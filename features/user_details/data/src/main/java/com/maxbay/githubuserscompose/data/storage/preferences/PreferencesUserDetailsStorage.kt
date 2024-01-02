package com.maxbay.githubuserscompose.data.storage.preferences

interface PreferencesUserDetailsStorage {
    suspend fun saveLastTimeCache(userId: Int, time: Long)
    suspend fun getLastTimeCache(userId: Int): Long
}