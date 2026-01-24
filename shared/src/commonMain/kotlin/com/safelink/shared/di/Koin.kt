package com.safelink.shared.di

import com.safelink.shared.data.datasource.ContactLocalDataSource
import com.safelink.shared.data.repository.ContactRepositoryImpl
import com.safelink.shared.data.repository.SettingsRepositoryImpl
import com.safelink.shared.domain.repository.ContactRepository
import com.safelink.shared.domain.repository.SettingsRepository
import com.safelink.shared.domain.usecase.AddContactUseCase
import com.safelink.shared.domain.usecase.DeleteContactUseCase
import com.safelink.shared.domain.usecase.GetContactsUseCase
import com.safelink.shared.domain.usecase.SendEmergencyAlertUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.dsl.KoinAppDeclaration

expect fun platformModule(): Module

val commonModule = module {
    // Data Sources
    single { ContactLocalDataSource(get()) }

    // Repositories
    single<ContactRepository> { ContactRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl() }

    // Use Cases
    factory { GetContactsUseCase(get()) }
    factory { AddContactUseCase(get()) }
    factory { DeleteContactUseCase(get()) }
    factory { SendEmergencyAlertUseCase(get(), get(), get(), get()) }
}



fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        commonModule,
        platformModule()
    )
}
