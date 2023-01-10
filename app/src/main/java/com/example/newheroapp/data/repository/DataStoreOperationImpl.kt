package com.example.newheroapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.newheroapp.domain.repository.DataStoreOperation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "hero_pref")

class DataStoreOperationImpl(context: Context) : DataStoreOperation {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "onBoarding_completed")
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) emit(
                emptyPreferences()
            ) else throw exception
        }.map { pref ->
            val onBoarding = pref[PreferencesKey.onBoardingKey] ?: false
            onBoarding
        }
    }
}