package com.safelink.shared.data.repository

import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.domain.repository.SettingsRepository

class SettingsRepositoryImpl(private val database: SafeLinkDatabase) : SettingsRepository {
    private val queries = database.settingsQueries

    companion object {
        private const val KEY_EMERGENCY_MESSAGE = "emergency_message"
        private const val DEFAULT_MESSAGE = "Help me! I am in danger."
    }

    override suspend fun saveEmergencyMessage(message: String) {
        queries.insertOrReplaceSetting(KEY_EMERGENCY_MESSAGE, message)
    }

    override suspend fun getEmergencyMessage(): String? {
        return queries.getSettingByKey(KEY_EMERGENCY_MESSAGE).executeAsOneOrNull() ?: DEFAULT_MESSAGE
    }
}
