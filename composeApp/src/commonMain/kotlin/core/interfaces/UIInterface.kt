package core.interfaces

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.channels.Channel

interface UIInterface {
    @Composable
    fun Spacer(size: Int) {
        Spacer(Modifier.height(size.dp))
    }

    @Composable
    fun VerticalSpacer(size: Int) {
        Spacer(Modifier.width(size.dp))
    }

    @Composable
    fun ShowSnackbar(message: String) {
        val snackbarHostState = remember { SnackbarHostState() }
        val channel = remember { Channel<Int>(Channel.CONFLATED) }
        LaunchedEffect(channel) {
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Long
            )
        }

        Scaffold(
            scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
            floatingActionButton = {
                channel.trySend(1)
            },
            content = {}
        )
    }
}