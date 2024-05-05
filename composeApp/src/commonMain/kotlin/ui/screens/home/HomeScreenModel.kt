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

    fun getNews() {
        screenModelScope.launch {
            try {
                val newsList = getNewsUseCase()
                _newsList.value = newsList
            } catch (e: Exception) {
            }
        }
    }

    fun webIntent(url: String) {
        startWebIntent(url)
    }
}