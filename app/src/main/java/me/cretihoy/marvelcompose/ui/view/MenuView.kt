package me.cretihoy.marvelcompose.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.cretihoy.marvelcompose.R
import me.cretihoy.marvelcompose.navigation.NavRoutes
import me.cretihoy.marvelcompose.ui.theme.Rounded
import me.cretihoy.marvelcompose.ui.theme.bottomMenuMinSize
import me.cretihoy.marvelcompose.ui.theme.spacingMedium
import me.cretihoy.marvelcompose.ui.theme.spacingSmall

@Composable
fun MenuView(
    navController: NavHostController = rememberNavController(),
    onClick: (() -> Unit)? = null,
    buttonText: String? = null,
    searchText: MutableState<String>? = null,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        reverseLayout = true,
        columns = GridCells.Adaptive(bottomMenuMinSize),
        horizontalArrangement = Arrangement.spacedBy(spacingMedium),
        verticalArrangement = Arrangement.spacedBy(spacingMedium)
    ) {
        item {
            Row(
                modifier = Modifier
                    .clip(shape = Rounded.medium)
                    .background(colors.onBackground)
                    .padding(spacingSmall),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButtonView(
                    backgroundColor = colors.background,
                    contentColor = colors.onBackground,
                    iconRes = R.drawable.ic_character
                ) {
                    navController.navigate(NavRoutes.CharacterListNavRoute.route)
                }

                IconButtonView(
                    backgroundColor = colors.background,
                    contentColor = colors.onBackground,
                    iconRes = R.drawable.ic_comic
                ) {
                    navController.navigate(NavRoutes.ComicListNavRoute.route)
                }

                IconButtonView(
                    backgroundColor = colors.background,
                    contentColor = colors.onBackground,
                    iconRes = R.drawable.ic_creator
                ) {
                    navController.navigate(NavRoutes.CreatorListNavRoute.route)
                }

                IconButtonView(
                    backgroundColor = colors.background,
                    contentColor = colors.onBackground,
                    iconRes = R.drawable.ic_event
                ) {
                    navController.navigate(NavRoutes.EventListNavRoute.route)
                }

                IconButtonView(
                    backgroundColor = colors.background,
                    contentColor = colors.onBackground,
                    iconRes = R.drawable.ic_series
                ) {
                    navController.navigate(NavRoutes.SeriesListNavRoute.route)
                }
            }
        }
        searchText?.let {
            item {
                Row {
                    TextFieldView(
                        text = searchText,
                        modifier = Modifier.weight(1f)
                    )
                    SpacerView()
                    ButtonView(
                        text = buttonText
                    ) { onClick?.invoke() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuView() {
    MenuView(
        searchText = mutableStateOf(PreviewFactory.getRandomName())
    )
}