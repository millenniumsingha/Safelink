package com.safelink.shared.domain.model

data class Contact(
    val id: Long?,
    val name: String,
    val phoneNumber: String,
    val isEmergencyContact: Boolean
)
