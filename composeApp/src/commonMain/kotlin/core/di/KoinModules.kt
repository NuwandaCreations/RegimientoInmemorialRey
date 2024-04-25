package core.di

import domain.useCases.GetDutiesUseCase
import org.koin.dsl.module
import ui.screens.duties.DutiesViewModel

val appModule = module {
    single { GetDutiesUseCase() }
}

val dataModule = module {

}

val screenModelModule = module {
    factory { DutiesViewModel() }
}