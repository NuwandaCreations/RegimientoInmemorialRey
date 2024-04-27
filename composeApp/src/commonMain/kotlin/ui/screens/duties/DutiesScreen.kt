package ui.screens.duties

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import core.interfaces.PdfType.DUTIES
import core.interfaces.UIInterface
import core.interfaces.buildPdfViewer
import ui.components.AppBar
import ui.components.ScreenType

class DutiesScreen : Screen, UIInterface {
    @Composable
    override fun Content() {
//        val screenModel = getScreenModel<DutiesViewModel>()
        val pdfViewer = remember { buildPdfViewer() }

        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Spacer(60)
            pdfViewer.showPdf(DUTIES)
        }

        AppBar(ScreenType.DUTIES)
    }
}