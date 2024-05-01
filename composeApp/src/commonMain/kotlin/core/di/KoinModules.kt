package core.di

import data.Repository
import data.network.StorageService
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.storage.FirebaseStorage
import dev.gitlive.firebase.storage.storage
import domain.useCases.GetDailyOrderUseCase
import domain.useCases.GetDutiesUseCase
import org.koin.dsl.module
import ui.screens.dailyOrder.DailyOrderScreenModel
import ui.screens.duties.DutiesViewModel

val appModule = module {
    single { GetDutiesUseCase(get()) }
    single { GetDailyOrderUseCase(get()) }
}

val dataModule = module {
    single { StorageService(provideFirebaseStorage()) }
    single { Repository(get()) }
}

val screenModelModule = module {
    single { DutiesViewModel(get()) }
    single { DailyOrderScreenModel(get()) }
}

fun provideFirebaseStorage(): FirebaseStorage = Firebase.storage