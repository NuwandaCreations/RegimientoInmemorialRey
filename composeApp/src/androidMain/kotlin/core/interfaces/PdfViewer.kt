package core.interfaces

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nuwandacreations.regimientoinmemorialreykmp.R
import com.rizzi.bouquet.HorizontalPDFReader
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberHorizontalPdfReaderState
import com.rizzi.bouquet.rememberVerticalPdfReaderState

class AndroidPdfViewer : PdfViewer {
    @Composable
    override fun showPdf(type: PdfType, url: String?) {
        if (type == PdfType.FBSTORAGE) {
            if (!url.isNullOrEmpty()) {
                val pdf = rememberVerticalPdfReaderState(
                    resource = ResourceType.Remote(url),
                    isZoomEnable = true
                )
                VerticalPDFReader(state = pdf, modifier = Modifier.fillMaxSize())
            }
        } else {
            val pdf = rememberHorizontalPdfReaderState(
                resource = ResourceType.Asset(R.raw.organization_charts),
                isZoomEnable = true
            )
            HorizontalPDFReader(state = pdf, modifier = Modifier.fillMaxSize())
        }
    }
}

actual fun buildPdfViewer(): PdfViewer = AndroidPdfViewer()