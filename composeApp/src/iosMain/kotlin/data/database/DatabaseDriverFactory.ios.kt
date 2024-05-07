package data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import inmemorialDatabase.InmemorialDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = InmemorialDatabase.Schema,
            name = "Inmemorial.Database.db"
        )
}