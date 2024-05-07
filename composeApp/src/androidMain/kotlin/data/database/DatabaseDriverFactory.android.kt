package data.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import inmemorialDatabase.InmemorialDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = InmemorialDatabase.Schema,
            context = context,
            name = "Inmemorial.Database.db"
        )
}