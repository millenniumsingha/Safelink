package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.LocationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DesktopLocationService : LocationService {
    override suspend fun getCurrentLocation(): LocationData? {
        // Stub for desktop
        return LocationData(40.7128, -74.0060, "New York, NY (Desktop Stub)")
    }

    override fun observeLocation(): Flow<LocationData> = flow {
        getCurrentLocation()?.let { emit(it) }
    }

    override fun isLocationEnabled(): Boolean {
        return true
    }
}
