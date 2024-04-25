package ui.screens.duties

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.useCases.GetDutiesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class DutiesViewModel : ScreenModel {
    private val getDutiesUseCase = GetDutiesUseCase()
//    private val client = HttpClient()
//    fun getPDF() {
//        screenModelScope.launch {
//            val response = client.get("https://file-examples.com/storage/feed2327706616bd9a07caa/2017/10/file-sample_150kB.pdf")
//        }
//    }
    fun getDuties() {
        getDutiesUseCase.getDuties()
    }
}