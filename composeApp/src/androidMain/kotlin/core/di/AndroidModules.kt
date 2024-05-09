package core.di

import data.database.DatabaseDriverFactory
import inmemorialDatabase.InmemorialDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory(androidContext()).createDriver() }
    single { InmemorialDatabase(get()) }
}