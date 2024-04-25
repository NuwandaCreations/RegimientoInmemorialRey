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
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import core.betaNetwork.BetaNetwork
import core.values.MyColor
import core.interfaces.UIInterface
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import regimientoinmemorialrey.composeapp.generated.resources.escudo_rinf1
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.concierto_colegiata
import regimientoinmemorialrey.composeapp.generated.resources.jura_bandera
import regimientoinmemorialrey.composeapp.generated.resources.relevo_guardia
import ui.screens.anthem.AnthemScreen
import ui.screens.dailyOrder.DailyOrderScreen
import ui.screens.duties.DutiesScreen
import ui.screens.organizationCharts.OrganizationCharts

class HomeScreen : Screen, UIInterface {
    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val betaNetwork = remember { BetaNetwork() }
        var menuExpanded by rememberSaveable { mutableStateOf(false) }

        Column(
            Modifier.fillMaxSize().background(color = Color.Black)
        ) {
            Spacer(20)
            Image(
                contentDescription = null,
                painter = painterResource(Res.drawable.escudo_rinf1),
                modifier = Modifier.fillMaxSize(),
                alpha = 0.7f
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = {
                    Text(
                        "RI \"INMEMORIAL DEL REY\" Nº1         ",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        menuExpanded = !menuExpanded
                    }) {
                        DropdownMenu(
                            expanded = menuExpanded,
                            modifier = Modifier.background(MyColor.Primary),
                            onDismissRequest = { menuExpanded = false }) {
                            DropdownMenuItem(onClick = { navigator?.push(DailyOrderScreen()) }) {
                                Text("Orden del día", color = Color.White)
                            }
                            DropdownMenuItem(onClick = { navigator?.push(DutiesScreen()) }) {
                                Text("Servicios", color = Color.White)
                            }
                            DropdownMenuItem(onClick = { navigator?.push(AnthemScreen()) }) {
                                Text("Himno RINF1", color = Color.White)
                            }
                            DropdownMenuItem(onClick = { navigator?.push(OrganizationCharts()) }) {
                                Text("Organigramas", color = Color.White)
                            }
                        }
                        Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                    }
                },
                backgroundColor = MyColor.Primary
            )

            Column(
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            ) {
                Card(
                    backgroundColor = MyColor.PrimaryAlpha,
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Actividades/jura-bandera-2024.html") }
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Jura de Bandera para personal civil",
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(15)
                        Image(
                            painter = painterResource(Res.drawable.jura_bandera),
                            contentDescription = null
                        )
                        Spacer(5)
                        Text(
                            "En el Palacio de Buenavista el día 11 de mayo de 2024 se va a celebrar el acto de Juramento a la Bandera de España del personal civil que lo solicite.",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }

                Card(
                    backgroundColor = MyColor.PrimaryAlpha,
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/palacio_buenavista/relevo-guardia-palacio-de-buenavista.html") }
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Relevo de la Guardia del Palacio de Buenavista",
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(15)
                        Image(
                            painter = painterResource(Res.drawable.relevo_guardia),
                            contentDescription = null
                        )
                        Spacer(5)
                        Text(
                            "Este solemne acto se celebra los últimos viernes de cada mes a excepción de julio, agosto y diciembre.",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }

                Card(
                    backgroundColor = MyColor.PrimaryAlpha,
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    onClick = { betaNetwork.externalOpen("https://ejercito.defensa.gob.es/unidades/Madrid/rinf1/Noticias/2024/41-concierto-colegiata-sanisidro.html") }
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "XX Concierto de marchas procesionales en la Real Colegiata de San Isidro, Madrid",
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            color = Color.White,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(15)
                        Image(
                            painter = painterResource(Res.drawable.concierto_colegiata),
                            contentDescription = null
                        )
                        Spacer(5)
                        Text(
                            "El pasado jueves 14 de marzo a las 20:00 h como cada año la Unidad de Música del Inmemorial del Rey ofreció su tradicional concierto de marchas procesionales en la Real Colegiata de San Isidro y Nuestra Señora del Buen Suceso (Madrid)",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}