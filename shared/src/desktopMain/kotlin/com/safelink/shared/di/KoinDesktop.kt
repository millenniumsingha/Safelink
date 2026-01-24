package com.safelink.shared.di

import com.safelink.shared.cache.DatabaseDriverFactory
import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.domain.service.LocationService
import com.safelink.shared.domain.service.MessagingService
import com.safelink.shared.domain.service.ShakeDetectionService
import com.safelink.shared.domain.service.DesktopLocationService
import com.safelink.shared.domain.service.DesktopMessagingService
import com.safelink.shared.domain.service.DesktopShakeDetectionService
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DatabaseDriverFactory() }
    single { get<DatabaseDriverFactory>().createDriver() }
    single { SafeLinkDatabase(get()) }

    single<LocationService> { DesktopLocationService() }
    single<MessagingService> { DesktopMessagingService() }
    single<ShakeDetectionService> { DesktopShakeDetectionService() }
}
