package me.cretihoy.marvelcompose.presentation.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.cretihoy.marvelcompose.navigation.NavRoutes
import me.cretihoy.marvelcompose.presentation.characters.CharacterListScreen
import me.cretihoy.marvelcompose.presentation.characters.CharacterListViewModel
import me.cretihoy.marvelcompose.presentation.characters.CurrentCharacterScreen
import me.cretihoy.marvelcompose.presentation.characters.CurrentCharacterViewModel
import me.cretihoy.marvelcompose.presentation.comics.ComicListScreen
import me.cretihoy.marvelcompose.presentation.comics.ComicListViewModel
import me.cretihoy.marvelcompose.presentation.comics.CurrentComicScreen
import me.cretihoy.marvelcompose.presentation.comics.CurrentComicViewModel
import me.cretihoy.marvelcompose.presentation.creators.CreatorListScreen
import me.cretihoy.marvelcompose.presentation.creators.CreatorListViewModel
import me.cretihoy.marvelcompose.presentation.creators.CurrentCreatorScreen
import me.cretihoy.marvelcompose.presentation.creators.CurrentCreatorViewModel
import me.cretihoy.marvelcompose.presentation.events.CurrentEventScreen
import me.cretihoy.marvelcompose.presentation.events.CurrentEventViewModel
import me.cretihoy.marvelcompose.presentation.events.EventListScreen
import me.cretihoy.marvelcompose.presentation.events.EventListViewModel
import me.cretihoy.marvelcompose.presentation.series.CurrentSeriesScreen
import me.cretihoy.marvelcompose.presentation.series.CurrentSeriesViewModel
import me.cretihoy.marvelcompose.presentation.series.SeriesListScreen
import me.cretihoy.marvelcompose.presentation.series.SeriesListViewModel
import me.cretihoy.marvelcompose.ui.theme.MarvelComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        MarvelComposeTheme {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                Column {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.CharacterListNavRoute.route,
                    ) {
                        composable(NavRoutes.CharacterListNavRoute.route) {
                            Column {
                                val viewModel = hiltViewModel<CharacterListViewModel>()
                                CharacterListScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.CurrentCharacterNavRoute.route + "/{characterName}") { backStackEntry ->
                            val characterString =
                                backStackEntry.arguments?.getString("characterName")
                            val viewModel = hiltViewModel<CurrentCharacterViewModel>()
                            Column {
                                CurrentCharacterScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    characterString,
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.ComicListNavRoute.route) {
                            Column {
                                val viewModel = hiltViewModel<ComicListViewModel>()
                                ComicListScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.CurrentComicNavRoute.route) {
                            val viewModel = hiltViewModel<CurrentComicViewModel>()
                            Column {
                                CurrentComicScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.EventListNavRoute.route) {
                            Column {
                                val viewModel = hiltViewModel<EventListViewModel>()
                                EventListScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.CurrentEventNavRoute.route) {
                            val viewModel = hiltViewModel<CurrentEventViewModel>()
                            Column {
                                CurrentEventScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }
                        composable(NavRoutes.CreatorListNavRoute.route) {
                            Column {
                                val viewModel = hiltViewModel<CreatorListViewModel>()
                                CreatorListScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.CurrentCreatorNavRoute.route) {
                            val viewModel = hiltViewModel<CurrentCreatorViewModel>()
                            Column {
                                CurrentCreatorScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    null,
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.SeriesListNavRoute.route) {
                            Column {
                                val viewModel = hiltViewModel<SeriesListViewModel>()
                                SeriesListScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }

                        composable(NavRoutes.CurrentSeriesNavRoute.route) {
                            val viewModel = hiltViewModel<CurrentSeriesViewModel>()
                            Column {
                                CurrentSeriesScreen(
                                    navController = navController,
                                    modifier = Modifier.weight(1f),
                                    viewModel = viewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}