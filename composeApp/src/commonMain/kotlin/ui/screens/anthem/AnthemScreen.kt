package ui.screens.anthem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import core.interfaces.UIInterface
import core.interfaces.buildAudioPlayer
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.anthem_lyrics
import regimientoinmemorialrey.composeapp.generated.resources.btn_pause
import regimientoinmemorialrey.composeapp.generated.resources.btn_play
import regimientoinmemorialrey.composeapp.generated.resources.btn_stop
import regimientoinmemorialrey.composeapp.generated.resources.escudo_rinf1
import ui.components.AppBar
import ui.components.ScreenType
import ui.theme.LightColors

class AnthemScreen : Screen, UIInterface {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        var isPlaying by rememberSaveable { mutableStateOf(false) }
        val player = remember { buildAudioPlayer() }
        LifecycleEffect(
            onDisposed = {
                player.stop()
            }
        )

        Box(
            Modifier.fillMaxSize().background(color = LightColors.background)
        ) {
            Image(
                contentDescription = null,
                painter = painterResource(Res.drawable.escudo_rinf1),
                modifier = Modifier.fillMaxSize(),
                alpha = 0.3f
            )
        }

        Column(
            Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                .padding(top = 75.dp, bottom = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (isPlaying) {
                Row {
                    IconButton(onClick = {
                        player.pause()
                        isPlaying = !isPlaying
                    }) {
                        Icon(
                            painterResource(Res.drawable.btn_pause),
                            null,
                            Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }

                    VerticalSpacer(30)

                    IconButton(onClick = {
                        player.stop()
                        isPlaying = !isPlaying
                    }) {
                        Icon(
                            painterResource(Res.drawable.btn_stop),
                            null,
                            Modifier.size(50.dp),
                            tint = Color.White
                        )
                    }
                }
            } else {
                IconButton(onClick = {
                    player.play()
                    isPlaying = !isPlaying
                }) {
                    Icon(
                        painterResource(Res.drawable.btn_play),
                        null,
                        Modifier.size(40.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(25)

            Text(
                stringResource(Res.string.anthem_lyrics),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            Spacer(25)
        }

        AppBar(ScreenType.ANTHEM)
    }
}