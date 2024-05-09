package ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.model.News
import domain.useCases.GetNewsUseCase
import domain.useCases.StartWebIntent
import kotlinx.coroutines.launch

class HomeScreenModel(private val getNewsUseCase: GetNewsUseCase, private val startWebIntent: StartWebIntent) : ScreenModel {
    private var _newsList = mutableStateOf(emptyList<News>())
    val newsList: State<List<News>> = _newsList

    fun getNews(uploadNews: Boolean = false) {
        screenModelScope.launch {
            try {
                val newsList = getNewsUseCase(uploadNews)
                _newsList.value = newsList
            } catch (_: Exception) {}
        }
    }

    fun webIntent(url: String) {
        try {
            startWebIntent(url)
        } catch (_: Exception) {}
    }
}