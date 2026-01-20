package com.safelink.shared.data.repository

import com.safelink.shared.domain.repository.SettingsRepository

class SettingsRepositoryImpl : SettingsRepository {
    // Mock implementation for now
    private var message: String? = "Help me! I am in danger."

    override suspend fun saveEmergencyMessage(message: String) {
        this.message = message
    }

    override suspend fun getEmergencyMessage(): String? {
        return message
    }
}
