package com.safelink.shared.di

import com.safelink.shared.cache.DatabaseDriverFactory
import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.domain.service.LocationService
import com.safelink.shared.domain.service.MessagingService
import com.safelink.shared.domain.service.ShakeDetectionService
import com.safelink.shared.domain.service.AndroidLocationService
import com.safelink.shared.domain.service.AndroidMessagingService
import com.safelink.shared.domain.service.AndroidShakeDetectionService
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DatabaseDriverFactory(get()) }
    single { get<DatabaseDriverFactory>().createDriver() }
    single { SafeLinkDatabase(get()) }
    
    // Services
    single<LocationService> { AndroidLocationService(get()) }
    single<MessagingService> { AndroidMessagingService(get()) }
    single<ShakeDetectionService> { AndroidShakeDetectionService(get()) }
}
