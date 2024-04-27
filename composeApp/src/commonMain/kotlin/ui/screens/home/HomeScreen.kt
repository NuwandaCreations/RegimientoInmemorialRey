package ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import core.betaNetwork.BetaNetwork
import core.interfaces.UIInterface
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import regimientoinmemorialrey.composeapp.generated.resources.escudo_rinf1
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.concierto_colegiata
import regimientoinmemorialrey.composeapp.generated.resources.jura_bandera
import regimientoinmemorialrey.composeapp.generated.resources.relevo_guardia
import ui.components.AppBar
import ui.components.ScreenType
import ui.theme.LightColors
import ui.theme.ParagraphStyle
import ui.theme.TitleParagraphStyle

class HomeScreen : Screen, UIInterface {
    @Composable
    override fun Content() {
        val betaNetwork = remember { BetaNetwork() }

        showBackground()
        showNews(betaNetwork)
        AppBar(ScreenType.HOME)
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun showBackground() {
        Column(
            Modifier.fillMaxSize().background(color = LightColors.background)
        ) {
            Spacer(20)
            Image(
                contentDescription = null,
                painter = painterResource(Res.drawable.escudo_rinf1),
                modifier = Modifier.fillMaxSize(),
                alpha = 0.7f
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
    @Composable
    fun showNews(betaNetwork: BetaNetwork) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()).padding(top = 55.dp)
        ) {
            Card(
                backgroundColor = LightColors.primaryVariant,
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Actividades/jura-bandera-2024.html") }
            ) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Jura de Bandera para personal civil",
                        style = TitleParagraphStyle
                    )
                    Spacer(15)
                    Image(
                        painter = painterResource(Res.drawable.jura_bandera),
                        contentDescription = null
                    )
                    Spacer(5)
                    Text(
                        "En el Palacio de Buenavista el día 11 de mayo de 2024 se va a celebrar el acto de Juramento a la Bandera de España del personal civil que lo solicite.",
                        style = ParagraphStyle
                    )
                }
            }

            Card(
                backgroundColor = LightColors.primaryVariant,
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/palacio_buenavista/relevo-guardia-palacio-de-buenavista.html") }
            ) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Relevo de la Guardia del Palacio de Buenavista",
                        style = TitleParagraphStyle
                    )
                    Spacer(15)
                    Image(
                        painter = painterResource(Res.drawable.relevo_guardia),
                        contentDescription = null
                    )
                    Spacer(5)
                    Text(
                        "Este solemne acto se celebra los últimos viernes de cada mes a excepción de julio, agosto y diciembre.",
                        style = ParagraphStyle
                    )
                }
            }

            Card(
                backgroundColor = LightColors.primaryVariant,
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Noticias/2024/41-concierto-colegiata-sanisidro.html") }
            ) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "XX Concierto de marchas procesionales en la Real Colegiata de San Isidro, Madrid",
                        style = TitleParagraphStyle
                    )
                    Spacer(15)
                    Image(
                        painter = painterResource(Res.drawable.concierto_colegiata),
                        contentDescription = null
                    )
                    Spacer(5)
                    Text(
                        "El pasado jueves 14 de marzo a las 20:00 h como cada año la Unidad de Música del Inmemorial del Rey ofreció su tradicional concierto de marchas procesionales en la Real Colegiata de San Isidro y Nuestra Señora del Buen Suceso (Madrid)",
                        style = ParagraphStyle
                    )
                }
            }
        }
    }
}