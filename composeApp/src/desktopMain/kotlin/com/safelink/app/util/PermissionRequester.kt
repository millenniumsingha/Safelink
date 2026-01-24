package com.safelink.app.util

import androidx.compose.runtime.Composable

@Composable
actual fun rememberSosPermissionRequester(
    onGranted: () -> Unit,
    onDenied: () -> Unit
): () -> Unit {
    // Desktop currently assumes permissions are granted or not strictly required in the same way
    return {
        onGranted()
    }
}
