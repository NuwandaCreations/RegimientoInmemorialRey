package ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.model.News
import domain.useCases.GetNewsUseCase
import domain.useCases.StartWebIntent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeScreenModel(private val getNewsUseCase: GetNewsUseCase, private val startWebIntent: StartWebIntent) : ScreenModel {
    private var _newsList = mutableStateOf(emptyList<News>())
    val newsList: State<List<News>> = _newsList

    private var _refreshState = mutableStateOf(false)
    val refreshState = _refreshState

    fun getNews(uploadNews: Boolean = false) {
        screenModelScope.launch {
            try {
                if (uploadNews) {
                    _refreshState.value = true
                    delay(2000)
                    getNewsCall(uploadNews)
                    _refreshState.value = false
                } else {
                    getNewsCall(uploadNews)
                }
            } catch (_: Exception) {}
        }
    }

    private suspend fun getNewsCall(uploadNews: Boolean) {
        val newsList = getNewsUseCase(uploadNews)
        _newsList.value = newsList
    }

    fun webIntent(url: String) {
        try {
            startWebIntent(url)
        } catch (_: Exception) {}
    }
}