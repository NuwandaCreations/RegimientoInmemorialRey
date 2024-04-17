package ui.screens.duties

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

class DutiesScreen: Screen {
    @Composable
    override fun Content() {

//        val resource = asyncPainterResource(data = "file-example_PDF_1MB.pdf")

//        val resource = asyncPainterResource(data = "https://yt3.googleusercontent.com/1juitwWoywWclScmf2Zb5DnV1TjPUDFkRRpGRPt194P1c7j9_LeADep2Cj8YZ1E_wNUbL9ApijQ=s900-c-k-c0x00ffffff-no-rj")
//        val viewModel = rememberScreenModel { DutiesViewModel() }


        Box(Modifier.fillMaxSize()) {
//            KamelImage(resource, contentDescription = "imagen")
        }
//        viewModel.getPDF()
    }
}