package com.safelink.shared.domain.repository

interface SettingsRepository {
    suspend fun saveEmergencyMessage(message: String)
    suspend fun getEmergencyMessage(): String?
}
