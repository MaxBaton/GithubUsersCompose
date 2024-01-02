package com.maxbay.githubuserscompose.data.storage.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import com.maxbay.githubuserscompose.data.ZERO_LONG_VALUE
import kotlinx.coroutines.flow.first

private const val LAST_TIME_CACHE_KEY_USER = "LAST_TIME_CACHE_KEY_USER"

class PreferencesUserDetailsStorageImpl(
    private val dataStore: DataStore<Preferences>
): PreferencesUserDetailsStorage {
    override suspend fun saveLastTimeCache(userId: Int, time: Long) {
        val key = getKeyLastTimeCacheForUser(userId = userId)
        dataStore.edit { prefs ->
            prefs[key] = time
        }
    }

    override suspend fun getLastTimeCache(userId: Int): Long {
        val key = getKeyLastTimeCacheForUser(userId = userId)
        return dataStore.data.first().get(key = key) ?: ZERO_LONG_VALUE
    }

    private fun getKeyLastTimeCacheForUser(userId: Int): Preferences.Key<Long> {
        val keyStr =  "${LAST_TIME_CACHE_KEY_USER}_$userId"
        return longPreferencesKey(name = keyStr)
    }
}