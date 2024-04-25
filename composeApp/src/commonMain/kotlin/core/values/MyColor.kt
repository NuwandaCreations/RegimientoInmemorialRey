package core.values

import androidx.compose.ui.graphics.Color

class MyColor {
    companion object {
        val Primary = Color(0xFFA9A3A1)
        val PrimaryAlpha = Primary.copy(alpha = 0.8f)
        val DarkRed = Color(0xFFc62828)
    }
}