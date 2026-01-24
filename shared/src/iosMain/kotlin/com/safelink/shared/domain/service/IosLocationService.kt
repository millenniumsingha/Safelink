package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.LocationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IosLocationService : LocationService {
    override suspend fun getCurrentLocation(): LocationData? {
        // Stub: In real app, implement CLLocationManager
        return LocationData(0.0, 0.0, "iOS Simulator Pkwy")
    }

    override fun observeLocation(): Flow<LocationData> = flow {
       getCurrentLocation()?.let { emit(it) }
    }

    override fun isLocationEnabled(): Boolean {
        return true
    }
}
