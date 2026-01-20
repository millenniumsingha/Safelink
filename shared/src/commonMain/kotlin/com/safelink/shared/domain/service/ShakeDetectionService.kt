package com.safelink.shared.domain.service

import kotlinx.coroutines.flow.Flow

interface ShakeDetectionService {
    fun startListening()
    fun stopListening()
    fun observeShakeEvents(): Flow<Unit>
}
