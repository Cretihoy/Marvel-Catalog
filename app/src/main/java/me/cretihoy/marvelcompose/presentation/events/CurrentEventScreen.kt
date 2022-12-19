package me.cretihoy.marvelcompose.presentation.events

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
import me.cretihoy.marvelcompose.presentation.characters.CharacterStorage
import me.cretihoy.marvelcompose.presentation.comics.ComicStorage
import me.cretihoy.marvelcompose.presentation.creators.CreatorStorage
import me.cretihoy.marvelcompose.presentation.series.SeriesStorage
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.view.ItemView
import me.cretihoy.marvelcompose.ui.view.LazyRowView
import me.cretihoy.marvelcompose.ui.view.ParagraphView
import me.cretihoy.marvelcompose.ui.view.SpacerView
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.model.data.model.SeriesModel

@Composable
fun CurrentEventScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: CurrentEventViewModel
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
            url = viewModel.event.value?.thumbnail?.getFullUrl().orEmpty(),
            text = viewModel.event.value?.title.orEmpty()
        )
        SpacerView()
        ParagraphView(
            text = stringResource(id = R.string.current_description_title),
            description = viewModel.event.value?.description
        )
        LazyRowView(
            title = stringResource(R.string.current_characters_title),
            items = viewModel.characters.value,
            onClick = { item ->
                CharacterStorage.currentCharacter = item as? CharacterModel
                val characterName = item?.getTitleOrNull()
                navController.navigate(NavRoutes.CurrentCharacterNavRoute.route+ "/$characterName")
            }
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
            title = stringResource(R.string.current_creators_title),
            items = viewModel.creators.value,
            onClick = { item ->
                CreatorStorage.currentCreator = item as? CreatorModel
                navController.navigate(NavRoutes.CurrentCreatorNavRoute.route)
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
