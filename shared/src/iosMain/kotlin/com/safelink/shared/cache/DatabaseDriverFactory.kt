package com.safelink.shared.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.safelink.shared.cache.SafeLinkDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SafeLinkDatabase.Schema, "safelink.db")
    }
}
