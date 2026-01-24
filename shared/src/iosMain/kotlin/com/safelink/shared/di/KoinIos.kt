package com.safelink.shared.di

import com.safelink.shared.cache.DatabaseDriverFactory
import com.safelink.shared.cache.SafeLinkDatabase
import com.safelink.shared.domain.service.LocationService
import com.safelink.shared.domain.service.MessagingService
import com.safelink.shared.domain.service.ShakeDetectionService
import com.safelink.shared.domain.service.IosLocationService
import com.safelink.shared.domain.service.IosMessagingService
import com.safelink.shared.domain.service.IosShakeDetectionService
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { DatabaseDriverFactory() }
    single { get<DatabaseDriverFactory>().createDriver() }
    single { SafeLinkDatabase(get()) }

    single<LocationService> { IosLocationService() }
    single<MessagingService> { IosMessagingService() }
    single<ShakeDetectionService> { IosShakeDetectionService() }
}
