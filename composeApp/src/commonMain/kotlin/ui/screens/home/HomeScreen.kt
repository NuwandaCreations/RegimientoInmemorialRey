package ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import core.interfaces.UIInterface
import domain.model.News
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.escudo_rinf1_antiguo
import regimientoinmemorialrey.composeapp.generated.resources.motto_head
import regimientoinmemorialrey.composeapp.generated.resources.motto_response
import ui.components.AppBar
import ui.components.ScreenType
import ui.theme.LightColors

class HomeScreen : Screen, UIInterface {
    @Composable
    override fun Content() {
        var newsList: List<News> by remember { mutableStateOf(emptyList()) }
        val screenModel = getScreenModel<HomeScreenModel>()
        if (newsList.isEmpty()) {
            screenModel.getNews()
            newsList = screenModel.newsList.value
        }

        initUI(newsList, screenModel)
        AppBar(ScreenType.HOME)
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun initUI(newsList: List<News>, screenModel: HomeScreenModel) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                LightColors.background
            ).fillMaxSize()
        ) {
            Text(
                text = stringResource(Res.string.motto_head),
                color = Color.White,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
            Spacer(70)
            Image(
                painter = painterResource(Res.drawable.escudo_rinf1_antiguo),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Spacer(70)
            Text(
                text = stringResource(Res.string.motto_response),
                color = Color.White,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
    }
}