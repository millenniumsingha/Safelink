package com.safelink.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.safelink.shared.di.initKoin

fun main() = application {
    initKoin()
    Window(onCloseRequest = ::exitApplication, title = "SafeLink") {
        App()
    }
}
