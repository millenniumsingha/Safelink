package com.safelink.app.util

import androidx.compose.runtime.Composable

@Composable
expect fun rememberSosPermissionRequester(
    onGranted: () -> Unit,
    onDenied: () -> Unit
): () -> Unit
