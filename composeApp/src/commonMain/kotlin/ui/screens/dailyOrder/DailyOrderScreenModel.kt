package ui.screens.dailyOrder

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.useCases.GetDailyOrderUseCase
import kotlinx.coroutines.launch

class DailyOrderScreenModel(private val getDailyOrderUseCase: GetDailyOrderUseCase): ScreenModel {
    private var _dailyOrderUrl = mutableStateOf("")
    val dailyOrderUrl: State<String> = _dailyOrderUrl

    private var _showDailyOrderError = mutableStateOf(false)
    val showDailyOrderError: State<Boolean> = _showDailyOrderError
    fun getDailyOrder() {
        screenModelScope.launch {
            try {
                val dailyOrderReference = getDailyOrderUseCase()
                _dailyOrderUrl.value = dailyOrderReference.getDownloadUrl()
            } catch (e: Exception) {
                _showDailyOrderError.value = true
            }
        }
    }
}