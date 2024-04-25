package core.interfaces

import androidx.compose.runtime.Composable

class IosPdfViewer: PdfViewer {
    @Composable
    override fun showPdf(type: PdfType) {
        TODO("Not yet implemented")
    }
}

actual fun buildPdfViewer(): PdfViewer = IosPdfViewer()