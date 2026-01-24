package com.safelink.app.util

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
actual fun rememberSosPermissionRequester(
    onGranted: () -> Unit,
    onDenied: () -> Unit
): () -> Unit {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val smsGranted = permissions["android.permission.SEND_SMS"] == true
        val fineLocationGranted = permissions["android.permission.ACCESS_FINE_LOCATION"] == true
        val coarseLocationGranted = permissions["android.permission.ACCESS_COARSE_LOCATION"] == true

        if (smsGranted && (fineLocationGranted || coarseLocationGranted)) {
            onGranted()
        } else {
            onDenied()
        }
    }

    return {
        launcher.launch(
            arrayOf(
                "android.permission.SEND_SMS",
                "android.permission.ACCESS_FINE_LOCATION",
                "android.permission.ACCESS_COARSE_LOCATION"
            )
        )
    }
}
