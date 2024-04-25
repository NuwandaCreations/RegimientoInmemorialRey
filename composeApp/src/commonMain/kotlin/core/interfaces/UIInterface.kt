package core.interfaces

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

interface UIInterface {
    @Composable
    fun Spacer(size: Int) {
        Spacer(Modifier.height(size.dp))
    }
    @Composable
    fun VerticalSpacer(size: Int) {
        Spacer(Modifier.width(size.dp))
    }
}