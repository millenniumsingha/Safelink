package com.safelink.shared.domain.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class DesktopShakeDetectionService : ShakeDetectionService {
    override fun startListening() {
        println("Desktop Shake - start listening (Stub)")
    }

    override fun stopListening() {
        println("Desktop Shake - stop listening (Stub)")
    }

    override fun observeShakeEvents(): Flow<Unit> {
        return emptyFlow()
    }
}
