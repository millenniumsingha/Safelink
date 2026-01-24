package com.safelink.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SafeLinkTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SafeLinkColors,
        content = content
    )
}
