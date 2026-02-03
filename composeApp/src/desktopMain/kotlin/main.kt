package com.safelink.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.safelink.shared.di.initKoin
import java.io.File
import java.io.PrintWriter
import java.io.StringWriter
import javax.swing.JOptionPane

fun main() {
    try {
        initKoin()
    } catch (e: Exception) {
        // Log exception to file for debugging packaged apps
        val logFile = File(System.getProperty("user.home"), "safelink_error.log")
        val sw = StringWriter()
        e.printStackTrace(PrintWriter(sw))
        logFile.writeText("SafeLink Startup Error:\n${sw}")
        
        // Show detailed error dialog
        JOptionPane.showMessageDialog(
            null,
            "Koin initialization failed:\n${e.message}\n\nSee ${logFile.absolutePath} for details",
            "SafeLink Error",
            JOptionPane.ERROR_MESSAGE
        )
        return
    }
    
    application {
        Window(onCloseRequest = ::exitApplication, title = "SafeLink") {
            App()
        }
    }
}
