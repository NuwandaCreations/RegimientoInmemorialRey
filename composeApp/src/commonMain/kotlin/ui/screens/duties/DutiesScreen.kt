package ui.screens.duties

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import core.interfaces.PdfType.FBSTORAGE
import core.interfaces.UIInterface
import core.interfaces.buildPdfViewer
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.stringResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.dutiesError
import ui.components.AppBar
import ui.components.ScreenType

class DutiesScreen : Screen, UIInterface {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DutiesViewModel>()
        screenModel.getDuties()
        val url = screenModel.dutiesUrl.value
        val pdfViewer = remember { buildPdfViewer() }

        if (screenModel.showDutiesError.value) {
            ShowSnackbar(stringResource(Res.string.dutiesError))
        }

        Column(Modifier.fillMaxSize()) {
            Spacer(60)
            pdfViewer.showPdf(FBSTORAGE, url)
        }
        AppBar(ScreenType.DUTIES)
    }
}