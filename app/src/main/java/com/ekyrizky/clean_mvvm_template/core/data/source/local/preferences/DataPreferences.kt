package com.ekyrizky.clean_mvvm_template.core.data.source.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(("setting"))
    private val pref = context.dataStore

    private val PREF_KEY = intPreferencesKey("your_key_int")
//    private val PREF_KEY = stringPreferencesKey("your_key_string")
//    private val PREF_KEY = booleanPreferencesKey("your_key_boolean")

    fun getPreferences(): Flow<Int> {
        return pref.data.map { preferences ->
            preferences[PREF_KEY] ?: 0
        }
    }

    suspend fun setPreferences(value: Int) {
        pref.edit { preferences ->
            preferences[PREF_KEY] = value
        }
    }
}