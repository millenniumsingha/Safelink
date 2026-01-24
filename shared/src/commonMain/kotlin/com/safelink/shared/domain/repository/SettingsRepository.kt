package com.safelink.shared.domain.repository

interface SettingsRepository {
    // TODO: Add settings methods (e.g., saveEmergencyMessage, getEmergencyMessage)
    suspend fun saveEmergencyMessage(message: String)
    suspend fun getEmergencyMessage(): String?
}
