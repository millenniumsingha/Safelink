package com.safelink.app.ui.theme

import androidx.compose.ui.graphics.Color

val RedPrimary = Color(0xFFD32F2F)
val RedSecondary = Color(0xFFFFCDD2)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val GrayBackground = Color(0xFFF5F5F5)

val SafeLinkColors = androidx.compose.material3.lightColorScheme(
    primary = RedPrimary,
    onPrimary = White,
    secondary = RedSecondary,
    onSecondary = Black,
    background = GrayBackground,
    surface = White,
    onSurface = Black
)
