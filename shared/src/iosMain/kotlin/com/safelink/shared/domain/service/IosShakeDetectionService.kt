package com.safelink.shared.domain.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import platform.Foundation.NSLog

class IosShakeDetectionService : ShakeDetectionService {
    override fun startListening() {
        NSLog("iOS Shake - start listening (Stub)")
    }

    override fun stopListening() {
        NSLog("iOS Shake - stop listening (Stub)")
    }

    override fun observeShakeEvents(): Flow<Unit> {
        return emptyFlow()
    }
}
