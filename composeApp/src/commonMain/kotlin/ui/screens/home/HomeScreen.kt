package ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import getPlatform
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import regimientoinmemorialrey.composeapp.generated.resources.Escudo_regimiento
import regimientoinmemorialrey.composeapp.generated.resources.Res
import ui.screens.anthem.AnthemScreen
import ui.screens.duties.DutiesScreen

class HomeScreen: Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val os = getPlatform()
        Row(
            Modifier.fillMaxSize()
                .paint(painterResource(Res.drawable.Escudo_regimiento))
        ) {
            Text("${os.name}")
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { navigator?.push(AnthemScreen()) }) {
                Text("Next")
            }
        }
    }
}