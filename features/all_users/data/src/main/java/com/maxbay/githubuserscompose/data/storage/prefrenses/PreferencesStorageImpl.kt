package com.maxbay.githubuserscompose.data.storage.prefrenses

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import com.maxbay.githubuserscompose.data.ZERO_LONG_VALUE
import kotlinx.coroutines.flow.first

private const val LAST_TIME_CACHE_KEY = "LAST_TIME_CACHE_KEY"

class PreferencesStorageImpl(
    private val dataStore: DataStore<Preferences>
): PreferencesStorage {
    private val lastTimeCacheKey: Preferences.Key<Long> = longPreferencesKey(name = LAST_TIME_CACHE_KEY)

    override suspend fun saveLastTimeCache(time: Long) {
        dataStore.edit { prefs ->
            prefs[lastTimeCacheKey] = time
        }
    }

    override suspend fun getLastTimeCache(): Long {
        return dataStore.data.first().get(key = lastTimeCacheKey) ?: ZERO_LONG_VALUE
    }
}