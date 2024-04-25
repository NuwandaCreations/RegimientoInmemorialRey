package core.interfaces

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nuwandacreations.regimientoinmemorialreykmp.R
import com.rizzi.bouquet.HorizontalPDFReader
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.rememberHorizontalPdfReaderState

class AndroidPdfViewer : PdfViewer {
    @Composable
    override fun showPdf(type: PdfType) {
        val pdf = if (type == PdfType.DUTIES) {
            rememberHorizontalPdfReaderState(
//                resource = ResourceType.Remote("https://myreport.altervista.org/Lorem_Ipsum.pdf"),
                resource = ResourceType.Asset(R.raw.duties2),
                isZoomEnable = true
            )
        } else {
            rememberHorizontalPdfReaderState(
                resource = ResourceType.Asset(R.raw.organization_charts),
                isZoomEnable = true
            )
        }

        HorizontalPDFReader(state = pdf, modifier = Modifier.fillMaxSize())
    }
}

actual fun buildPdfViewer(): PdfViewer = AndroidPdfViewer()