package ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
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
import coil3.compose.AsyncImage
import core.interfaces.UIInterface
import domain.model.News
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.motto_head
import regimientoinmemorialrey.composeapp.generated.resources.motto_response
import regimientoinmemorialrey.composeapp.generated.resources.news
import regimientoinmemorialrey.composeapp.generated.resources.palacio_buenavista
import ui.components.AppBar
import ui.components.ScreenType
import ui.theme.LightColors
import ui.theme.ParagraphStyle
import ui.theme.TitleParagraphStyle

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

    @Composable
    fun initUI(newsList: List<News>,screenModel: HomeScreenModel) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(
                LightColors.background
            ).fillMaxSize()
        ) {
            item { showHeader() }
            items(newsList.size) { showNews(newsList, screenModel, it) }
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun showHeader() {
        Spacer(200)
        Text(
            text = stringResource(Res.string.motto_head),
            color = Color.White,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Spacer(20)
        Image(
            painter = painterResource(Res.drawable.palacio_buenavista),
            contentDescription = null,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(20)
        Text(
            text = stringResource(Res.string.motto_response),
            color = Color.White,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Spacer(150)
        Text(
            stringResource(Res.string.news),
            color = LightColors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun showNews(newsList: List<News>,screenModel: HomeScreenModel, index: Int) {
        val news = newsList[index]
        Card(
            backgroundColor = LightColors.primaryVariant.copy(alpha = 0.3f),
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            onClick = {
                news.url?.let { screenModel.webIntent(it) }
            }
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = news.photo,
                    contentDescription = null,
                    modifier = Modifier.size(400.dp, 400.dp)
                )
                news.title?.let {
                    Text(
                        text = it,
                        style = TitleParagraphStyle,
                        color = LightColors.primary,
                        modifier = Modifier.align(Alignment.TopCenter)
                            .background(Color.Black.copy(alpha = 0.5f))
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )
                }
                news.date?.let {
                    Text(
                        text = "Fecha publicación: $it",
                        style = ParagraphStyle,
                        color = LightColors.primary,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .background(Color.Black.copy(alpha = 0.5f))
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )
                }
            }
        }
    }
}