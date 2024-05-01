package ui.screens.organizationCharts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import core.interfaces.PdfType.ORGANIZATION
import core.interfaces.buildPdfViewer
import ui.components.AppBar
import ui.components.ScreenType

class OrganizationCharts : Screen {
    @Composable
    override fun Content() {
        val pdfViewer = remember { buildPdfViewer() }

        Box(Modifier.fillMaxSize()) {
            pdfViewer.showPdf(ORGANIZATION, null)
        }
        AppBar(ScreenType.ORGANIZATION)
    }
}