package com.safelink.shared.domain.model

data class EmergencyMessage(
    val message: String,
    val recipients: List<Contact>,
    val location: LocationData? = null
)
