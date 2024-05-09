package core.interfaces

import androidx.compose.runtime.Composable

interface PdfViewer {
    @Composable
    fun showPdf(type: PdfType, url: String?)
}

expect fun buildPdfViewer() : PdfViewer

enum class PdfType {
    ORGANIZATION, FBSTORAGE
}