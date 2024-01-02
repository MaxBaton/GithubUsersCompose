package com.maxbay.githubuserscompose.data.storage.prefrenses

interface PreferencesStorage {
    suspend fun saveLastTimeCache(time: Long)
    suspend fun getLastTimeCache(): Long
}