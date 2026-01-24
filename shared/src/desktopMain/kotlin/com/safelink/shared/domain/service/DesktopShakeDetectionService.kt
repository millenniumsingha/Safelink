package com.safelink.shared.domain.service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class DesktopShakeDetectionService : ShakeDetectionService {
    override fun startListening() {
        // Desktop stub: Shake detection not supported
    }

    override fun stopListening() {
        // Desktop stub: Shake detection not supported
    }

    override fun observeShakeEvents(): Flow<Unit> {
        return emptyFlow()
    }
}
