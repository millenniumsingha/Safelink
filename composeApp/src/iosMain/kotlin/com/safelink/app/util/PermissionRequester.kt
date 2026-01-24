package com.safelink.app.util

import androidx.compose.runtime.Composable

@Composable
actual fun rememberSosPermissionRequester(
    onGranted: () -> Unit,
    onDenied: () -> Unit
): () -> Unit {
    // iOS permission handling is different (info.plist + runtime), stubbing for now
    return {
        onGranted()
    }
}
