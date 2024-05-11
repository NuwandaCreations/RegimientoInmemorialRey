package ui.screens.news

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import coil3.compose.AsyncImage
import core.interfaces.UIInterface
import domain.model.News
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.escudo_rinf1
import ui.components.AppBar
import ui.components.ScreenType
import ui.screens.home.HomeScreenModel
import ui.theme.LightColors
import ui.theme.ParagraphStyle
import ui.theme.TitleParagraphStyle

class NewsScreen : Screen, UIInterface {
    @Composable
    override fun Content() {
        var newsList: List<News> by remember { mutableStateOf(emptyList()) }
        val screenModel = getScreenModel<HomeScreenModel>()
        if (newsList.isEmpty()) {
            screenModel.getNews(false)
            newsList = screenModel.newsList.value
        }

        initUI(newsList, screenModel)
        AppBar(ScreenType.NEWS)
    }

    @OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
    @Composable
    fun initUI(newsList: List<News>, screenModel: HomeScreenModel) {
        val refreshing by screenModel.refreshState
        val pullRefreshState = rememberPullRefreshState(refreshing, { screenModel.getNews(true) })
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
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().pullRefresh(pullRefreshState)
        ) {
            item { Spacer(50) }
            items(newsList.size) { showNews(newsList, screenModel, it) }
        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(50)
            PullRefreshIndicator(
                refreshing = true,
                state = pullRefreshState,
                backgroundColor = LightColors.primary
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun showNews(newsList: List<News>, screenModel: HomeScreenModel, index: Int) {
        val news = newsList[index]
        Card(
            backgroundColor = LightColors.background,
            border = BorderStroke(1.dp, LightColors.primary),
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