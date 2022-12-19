package me.cretihoy.marvelcompose.presentation.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import me.cretihoy.marvelcompose.R
import me.cretihoy.marvelcompose.navigation.NavRoutes
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.itemViewMinSize
import me.cretihoy.marvelcompose.ui.theme.spacingLarge
import me.cretihoy.marvelcompose.ui.theme.spacingMedium
import me.cretihoy.marvelcompose.ui.view.*

@Composable
fun EventListScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: EventListViewModel
) {
    Column(
        modifier = modifier
            .padding(
                start = spacingLarge,
                end = spacingLarge,
                top = spacingLarge,
                bottom = spacingMedium
            )
    ) {
        if (viewModel.events.value.isNotEmpty()) {
            LazyVerticalGrid(
                modifier = Modifier
                    .clip(shape = Rounded.large)
                    .weight(1f),
                columns = GridCells.Adaptive(itemViewMinSize),
                horizontalArrangement = Arrangement.spacedBy(spacingMedium),
                verticalArrangement = Arrangement.spacedBy(spacingMedium),
            ) {
                itemsIndexed(viewModel.events.value) { index, item ->
                    ItemView(
                        url = item.thumbnail?.getFullUrl().orEmpty(),
                        text = item.title.orEmpty(),
                        onClick = {
                            EventStorage.currentEvent = item
                            navController.navigate(NavRoutes.CurrentEventNavRoute.route)
                        }
                    )
                    if (index < (viewModel.events.value.lastIndex)) SpacerView()
                }
            }
        } else {
            Text(
                text = viewModel.errorMessage.value,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
        SpacerView()
        MenuView(
            navController = navController,
            onClick = {
                viewModel.onButtonClicked()
            },
            buttonText = stringResource(R.string.list_search_button),
            searchText = viewModel.searchText
        )
    }
}