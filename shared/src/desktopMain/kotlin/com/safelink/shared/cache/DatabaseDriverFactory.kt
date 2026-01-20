package com.safelink.shared.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.safelink.shared.cache.SafeLinkDatabase
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver("jdbc:sqlite:safelink.db")
        if (!File("safelink.db").exists()) {
             SafeLinkDatabase.Schema.create(driver)
        }
        return driver
    }
}
