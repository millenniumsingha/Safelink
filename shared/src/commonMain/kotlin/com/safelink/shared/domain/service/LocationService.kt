package com.safelink.shared.domain.service

import com.safelink.shared.domain.model.LocationData
import kotlinx.coroutines.flow.Flow

interface LocationService {
    suspend fun getCurrentLocation(): LocationData?
    fun observeLocation(): Flow<LocationData>
    fun isLocationEnabled(): Boolean
}
