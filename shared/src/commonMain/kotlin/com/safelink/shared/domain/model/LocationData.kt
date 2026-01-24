package com.safelink.shared.domain.model

data class LocationData(
    val latitude: Double,
    val longitude: Double,
    val address: String? = null,
    val timestamp: Long = 0L
)
