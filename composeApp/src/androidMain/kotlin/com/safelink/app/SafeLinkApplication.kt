package com.safelink.app

import android.app.Application
import com.safelink.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class SafeLinkApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@SafeLinkApplication)
        }
    }
}
