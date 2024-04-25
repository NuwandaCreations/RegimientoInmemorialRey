package ui.screens.duties

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import core.interfaces.PdfType.DUTIES
import core.interfaces.buildPdfViewer

class DutiesScreen: Screen {
    @Composable
    override fun Content() {
//        val screenModel = getScreenModel<DutiesViewModel>()
        val pdfViewer = remember { buildPdfViewer() }

        Box(Modifier.fillMaxSize()) {
            pdfViewer.showPdf(DUTIES)
        }
    }
}