package com.safelink.shared.domain.usecase

import com.safelink.shared.domain.repository.ContactRepository
import com.safelink.shared.domain.repository.SettingsRepository
import com.safelink.shared.domain.service.LocationService
import com.safelink.shared.domain.service.MessagingService
import kotlinx.coroutines.flow.first

class SendEmergencyAlertUseCase(
    private val locationService: LocationService,
    private val messagingService: MessagingService,
    private val contactRepository: ContactRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke() {
        val location = locationService.getCurrentLocation()
        // Take the first emission from the Flow to get the current list of contacts
        val contacts = contactRepository.getContacts().first()
        val messageTemplate = settingsRepository.getEmergencyMessage() ?: "Help! I am in danger."

        val fullMessage = buildString {
            append(messageTemplate)
            if (location != null) {
                append("\nLocation: https://maps.google.com/?q=${location.latitude},${location.longitude}")
                if (location.address != null) {
                    append("\nAddress: ${location.address}")
                }
            }
        }

        contacts.filter { it.isEmergencyContact }.forEach { contact ->
            messagingService.sendSms(contact, fullMessage)
        }
    }
}
