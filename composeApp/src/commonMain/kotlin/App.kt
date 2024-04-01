import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import regimientoinmemorialrey.composeapp.generated.resources.Escudo_regimiento
import regimientoinmemorialrey.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    PreComposeApp {
        MaterialTheme {
            val navigator = rememberNavigator()
            NavHost(
                navigator = navigator,
                navTransition = NavTransition(),
                initialRoute = "/home"
            ) {
                scene(route = "/home", navTransition = NavTransition()) {
                    Box(
                        Modifier.fillMaxSize()
                            .paint(painterResource(Res.drawable.Escudo_regimiento))
                    ) {
//            Image(painter = painterResource(Res.drawable.Escudo_regimiento), "hola")
                    }
                }
                scene(route = "/secondScene", navTransition = NavTransition()) {
                    Text(text = "segunda escena")
                }
            }
//            navigator.navigate("/secondScene")
        }
    }
}