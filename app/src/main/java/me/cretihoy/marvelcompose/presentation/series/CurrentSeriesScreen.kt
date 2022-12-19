package me.cretihoy.marvelcompose.presentation.series

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
import me.cretihoy.marvelcompose.presentation.events.EventStorage
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.view.ItemView
import me.cretihoy.marvelcompose.ui.view.LazyRowView
import me.cretihoy.marvelcompose.ui.view.ParagraphView
import me.cretihoy.marvelcompose.ui.view.SpacerView
import me.cretihoy.model.data.model.CharacterModel
import me.cretihoy.model.data.model.ComicModel
import me.cretihoy.model.data.model.CreatorModel
import me.cretihoy.model.data.model.EventModel

@Composable
fun CurrentSeriesScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: CurrentSeriesViewModel
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
            url = viewModel.series.value?.thumbnail?.getFullUrl().orEmpty(),
            text = viewModel.series.value?.title.orEmpty()
        )
        SpacerView()
        ParagraphView(
            text = stringResource(id = R.string.current_description_title),
            description = viewModel.series.value?.description
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
            title = stringResource(R.string.current_events_title),
            items = viewModel.events.value,
            onClick = { item ->
                EventStorage.currentEvent = item as? EventModel
                navController.navigate(NavRoutes.CurrentEventNavRoute.route)
            }
        )
        LazyRowView(
            title = stringResource(R.string.current_stories_title),
            items = viewModel.stories.value,
        )
    }
}


