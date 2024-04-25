package ui

import android.app.Application
import android.content.Context
import core.di.appModule
import core.di.dataModule
import core.di.screenModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RegimientoInmemorialReyApp: Application() {
    companion object {
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            androidLogger()
            androidContext(this@RegimientoInmemorialReyApp)
            modules(
                appModule,
                dataModule,
                screenModelModule
            )
        }
    }
}