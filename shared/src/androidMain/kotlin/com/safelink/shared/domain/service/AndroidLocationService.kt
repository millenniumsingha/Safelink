package com.safelink.shared.domain.service

import android.content.Context
import android.location.LocationManager
import com.safelink.shared.domain.model.LocationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AndroidLocationService(private val context: Context) : LocationService {
    override suspend fun getCurrentLocation(): LocationData? {
        // Simple implementation using LocationManager network provider for now
        // In a real app, use FusedLocationProviderClient
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return try {
            val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            location?.let {
                LocationData(it.latitude, it.longitude)
            }
        } catch (e: SecurityException) {
            null
        }
    }

    override fun observeLocation(): Flow<LocationData> = flow {
        // Stub: Emits current location once
        getCurrentLocation()?.let { emit(it) }
    }

    override fun isLocationEnabled(): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }
}
