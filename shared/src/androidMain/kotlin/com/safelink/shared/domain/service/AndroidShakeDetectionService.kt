package com.safelink.shared.domain.service

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlin.math.sqrt

class AndroidShakeDetectionService(private val context: Context) : ShakeDetectionService {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var shakeListener: (() -> Unit)? = null

    override fun startListening() {
        // Implementation handled in observeShakeEvents
    }

    override fun stopListening() {
        // Implementation handled in observeShakeEvents
    }

    override fun observeShakeEvents(): Flow<Unit> = callbackFlow {
        val listener = object : SensorEventListener {
            private var acceleration = 0f
            private var currentAcceleration = SensorManager.GRAVITY_EARTH
            private var lastAcceleration = SensorManager.GRAVITY_EARTH

            override fun onSensorChanged(event: SensorEvent) {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                lastAcceleration = currentAcceleration
                currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
                val delta = currentAcceleration - lastAcceleration
                acceleration = acceleration * 0.9f + delta

                if (acceleration > 12) { // Shake threshold
                    trySend(Unit)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(
            listener,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )

        awaitClose {
            sensorManager.unregisterListener(listener)
        }
    }
}
