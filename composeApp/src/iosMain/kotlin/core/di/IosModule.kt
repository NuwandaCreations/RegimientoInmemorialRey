package core.di

import data.database.DatabaseDriverFactory
import inmemorialDatabase.InmemorialDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory().createDriver() }
    single { InmemorialDatabase(get()) }
}