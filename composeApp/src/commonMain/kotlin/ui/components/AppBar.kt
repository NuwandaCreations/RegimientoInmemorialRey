package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import regimientoinmemorialrey.composeapp.generated.resources.Res
import regimientoinmemorialrey.composeapp.generated.resources.anthem
import regimientoinmemorialrey.composeapp.generated.resources.appbar_name
import regimientoinmemorialrey.composeapp.generated.resources.dailyOrder
import regimientoinmemorialrey.composeapp.generated.resources.duties
import regimientoinmemorialrey.composeapp.generated.resources.home
import regimientoinmemorialrey.composeapp.generated.resources.ic_anthem
import regimientoinmemorialrey.composeapp.generated.resources.ic_daily_order
import regimientoinmemorialrey.composeapp.generated.resources.ic_duties
import regimientoinmemorialrey.composeapp.generated.resources.ic_home
import regimientoinmemorialrey.composeapp.generated.resources.ic_news
import regimientoinmemorialrey.composeapp.generated.resources.ic_organization
import regimientoinmemorialrey.composeapp.generated.resources.news
import regimientoinmemorialrey.composeapp.generated.resources.organization
import ui.screens.anthem.AnthemScreen
import ui.screens.dailyOrder.DailyOrderScreen
import ui.screens.duties.DutiesScreen
import ui.screens.home.HomeScreen
import ui.screens.news.NewsScreen
import ui.screens.organizationCharts.OrganizationCharts
import ui.theme.LightColors
import ui.theme.SelectedItem

enum class ScreenType {
    HOME, DAILYORDER, DUTIES, ANTHEM, ORGANIZATION, NEWS
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppBar(screenType: ScreenType) {
    var menuExpanded by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(
                    stringResource(Res.string.appbar_name),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(end = 30.dp),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    menuExpanded = !menuExpanded
                }) {
                    Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                }
            },
            backgroundColor = LightColors.primary
        )
        Box {
            if (menuExpanded) {
                showNavRail(screenType)
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun showNavRail(screenType: ScreenType) {
    val navigator = LocalNavigator.current
    val selectedItem by remember {
        mutableIntStateOf(
            when (screenType) {
                ScreenType.HOME -> 0
                ScreenType.DAILYORDER -> 1
                ScreenType.ORGANIZATION -> 2
                ScreenType.ANTHEM -> 3
                ScreenType.DUTIES -> 4
                ScreenType.NEWS -> 5
            }
        )
    }
    val items = listOf(
        stringResource(Res.string.home),
        stringResource(Res.string.dailyOrder),
        stringResource(Res.string.organization),
        stringResource(Res.string.anthem),
        stringResource(Res.string.duties),
        stringResource(Res.string.news)
    )
    val icons = listOf(
        painterResource(Res.drawable.ic_home),
        painterResource(Res.drawable.ic_daily_order),
        painterResource(Res.drawable.ic_organization),
        painterResource(Res.drawable.ic_anthem),
        painterResource(Res.drawable.ic_duties),
        painterResource(Res.drawable.ic_news)
    )
    NavigationRail(
        backgroundColor = LightColors.primary, modifier = Modifier.fillMaxHeight().verticalScroll(
            rememberScrollState()
        )
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = {
                    Icon(
                        painter = icons[index],
                        contentDescription = item,
                        modifier = Modifier.size(30.dp, 30.dp),
                    )
                },
                label = { Text(text = item) },
                selected = selectedItem == index,
                selectedContentColor = SelectedItem,
                unselectedContentColor = Color.Black,
                onClick = {
                    if (selectedItem != index) {
                        when (index) {
                            0 -> {
                                navigator?.push(HomeScreen())
                            }
                            1 -> {
                                navigator?.push(DailyOrderScreen())
                            }
                            2 -> {
                                navigator?.push(OrganizationCharts())
                            }
                            3 -> {
                                navigator?.push(AnthemScreen())
                            }
                            4 -> {
                                navigator?.push(DutiesScreen())
                            }
                            5 -> {
                                navigator?.push(NewsScreen())
                            }
                            else -> {}
                        }
                    }
                }
            )
        }
    }
}