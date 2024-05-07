package core.di

import org.koin.core.context.startKoin

fun initKoin() {
    val modules = appModule + dataModule + screenModelModule + databaseModule

    startKoin {
        modules(modules)
    }
}