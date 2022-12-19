package me.cretihoy.marvelcompose.presentation.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.cretihoy.marvelcompose.R
import me.cretihoy.marvelcompose.navigation.NavRoutes
import me.cretihoy.marvelcompose.presentation.comics.ComicStorage
import me.cretihoy.marvelcompose.presentation.events.EventStorage
import me.cretihoy.marvelcompose.presentation.series.SeriesStorage
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.view.ItemView
import me.cretihoy.marvelcompose.ui.view.LazyRowView
import me.cretihoy.marvelcompose.ui.view.ParagraphView
import me.cretihoy.marvelcompose.ui.view.SpacerView
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.model.data.model.SeriesModel

@Composable
fun CurrentCharacterScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier,
    characterName: String?,
    viewModel: CurrentCharacterViewModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SpacerView(spacingLarge)
        ItemView(
            modifier = Modifier.padding(horizontal = spacingLarge),
            url = viewModel.character.value?.thumbnail?.getFullUrl().orEmpty(),
            text = viewModel.character.value?.name.orEmpty()
        )
        SpacerView()
        ParagraphView(
            text = stringResource(id = R.string.current_description_title),
            description = viewModel.character.value?.description
        )
        LazyRowView(
            title = stringResource(R.string.current_comics_title),
            items = viewModel.comics.value,
            onClick = { item ->
                ComicStorage.currentComic = item as? ComicModel
                navController.navigate(NavRoutes.CurrentComicNavRoute.route)
            }
        )
        LazyRowView(
            title = stringResource(R.string.current_events_title),
            items = viewModel.events.value,
            onClick = { item ->
                EventStorage.currentEvent = item as? EventModel
                navController.navigate(NavRoutes.CurrentEventNavRoute.route)
            }
        )
        LazyRowView(
            title = stringResource(R.string.current_series_title),
            items = viewModel.series.value,
            onClick = { item ->
                SeriesStorage.currentSeries = item as? SeriesModel
                navController.navigate(NavRoutes.CurrentSeriesNavRoute.route)
            }
        )
        LazyRowView(
            title = stringResource(R.string.current_stories_title),
            items = viewModel.stories.value,
        )
    }
}