package com.safelink.app

import androidx.compose.ui.window.ComposeUIViewController
import com.safelink.shared.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
