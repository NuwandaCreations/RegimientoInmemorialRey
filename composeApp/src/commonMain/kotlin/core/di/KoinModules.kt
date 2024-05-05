package core.di

import data.Repository
import data.network.StorageService
import data.network.WebService
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.storage.FirebaseStorage
import dev.gitlive.firebase.storage.storage
import domain.useCases.GetDailyOrderUseCase
import domain.useCases.GetDutiesUseCase
import domain.useCases.GetNewsUseCase
import domain.useCases.StartWebIntent
import org.koin.dsl.module
import ui.screens.dailyOrder.DailyOrderScreenModel
import ui.screens.duties.DutiesScreenModel
import ui.screens.home.HomeScreenModel

val appModule = module {
    single { GetDutiesUseCase(get()) }
    single { GetDailyOrderUseCase(get()) }
    single { GetNewsUseCase(get()) }
    single { StartWebIntent(get()) }
}

val dataModule = module {
    single { StorageService(provideFirebaseStorage()) }
    single { WebService() }
    single { Repository(get(), get()) }
}

val screenModelModule = module {
    single { DutiesScreenModel(get()) }
    single { DailyOrderScreenModel(get()) }
    single { HomeScreenModel(get(), get()) }
}

fun provideFirebaseStorage(): FirebaseStorage = Firebase.storage