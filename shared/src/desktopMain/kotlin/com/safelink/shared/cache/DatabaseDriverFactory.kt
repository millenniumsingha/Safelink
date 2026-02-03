package com.safelink.shared.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.safelink.shared.cache.SafeLinkDatabase
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        // Use user-writable AppData directory for database storage
        // This avoids "Access is denied" errors when installed in Program Files
        val appDataDir = System.getenv("APPDATA") ?: System.getProperty("user.home")
        val safelinkDir = File(appDataDir, "SafeLink")
        if (!safelinkDir.exists()) {
            safelinkDir.mkdirs()
        }
        val dbFile = File(safelinkDir, "safelink.db")
        val dbPath = dbFile.absolutePath.replace("\\", "/")
        
        val driver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
        if (!dbFile.exists()) {
            SafeLinkDatabase.Schema.create(driver)
        }
        return driver
    }
}
