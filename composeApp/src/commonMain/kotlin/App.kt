import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import regimientoinmemorialrey.composeapp.generated.resources.Escudo_regimiento
import regimientoinmemorialrey.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val os = getPlatform()
        Box(
            Modifier.fillMaxSize()
                .paint(painterResource(Res.drawable.Escudo_regimiento))
        ) {
            Text("${os.name}")
        }
    }
}