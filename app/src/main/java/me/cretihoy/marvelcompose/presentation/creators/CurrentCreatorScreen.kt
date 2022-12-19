package me.cretihoy.marvelcompose.presentation.creators

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import me.cretihoy.marvelcompose.R
import me.cretihoy.marvelcompose.navigation.NavRoutes
import me.cretihoy.marvelcompose.presentation.comics.ComicStorage
import me.cretihoy.marvelcompose.presentation.events.EventStorage
import me.cretihoy.marvelcompose.presentation.series.SeriesStorage
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.view.ItemView
import me.cretihoy.marvelcompose.ui.view.LazyRowView
import me.cretihoy.marvelcompose.ui.view.SpacerView
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.EventModel
import me.cretihoy.model.data.model.SeriesModel

@Composable
fun CurrentCreatorScreen(
    navController: NavHostController,
    modifier: Modifier,
    characterName: String?,
    viewModel: CurrentCreatorViewModel
) {
    Column(
        modifier = modifier
            .padding(horizontal = spacingLarge)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SpacerView(spacingLarge)
        ItemView(
            modifier = Modifier.padding(horizontal = spacingLarge),
            url = viewModel.creator.value?.thumbnail?.getFullUrl().orEmpty(),
            text = viewModel.creator.value?.fullName.orEmpty()
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
