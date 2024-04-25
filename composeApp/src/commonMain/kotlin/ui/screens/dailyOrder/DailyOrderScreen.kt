package ui.screens.dailyOrder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import core.betaNetwork.BetaNetwork

class DailyOrderScreen: Screen {
    @Composable
    override fun Content() {
        val betaNetwork = remember { BetaNetwork() }
        betaNetwork.externalOpen("https://drive.google.com/file/d/1pmaHZKJssRqom9wm1Lngn1PqwPt6Y1rd/view?usp=sharing")
    }
}