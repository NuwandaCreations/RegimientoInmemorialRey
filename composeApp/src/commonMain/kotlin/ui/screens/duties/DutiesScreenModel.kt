package ui.screens.duties

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import domain.useCases.GetDutiesUseCase
import kotlinx.coroutines.launch

class DutiesScreenModel(val getDutiesUseCase: GetDutiesUseCase) : ScreenModel {
    private var _dutiesUrl = mutableStateOf("")
    val dutiesUrl: State<String> = _dutiesUrl

    private var _showDutiesError = mutableStateOf(false)
    val showDutiesError: State<Boolean> = _showDutiesError

    fun getDuties() {
        screenModelScope.launch {
            try {
                val dutiesReference = getDutiesUseCase()
                _dutiesUrl.value = dutiesReference.getDownloadUrl()
            } catch (e: Exception) {
                _showDutiesError.value = true
            }
        }
    }
}