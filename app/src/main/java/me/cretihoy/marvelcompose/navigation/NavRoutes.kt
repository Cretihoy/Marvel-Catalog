package me.cretihoy.marvelcompose.navigation

sealed class NavRoutes(val route: String) {

    //character
    object CharacterListNavRoute : NavRoutes("CharacterListNavRoute")
    object CurrentCharacterNavRoute : NavRoutes("CurrentCharacterNavRoute")

    //comic
    object ComicListNavRoute : NavRoutes("ComicListNavRoute")
    object CurrentComicNavRoute : NavRoutes("CurrentComicNavRoute")

    //creator
    object CreatorListNavRoute : NavRoutes("CreatorListNavRoute")
    object CurrentCreatorNavRoute : NavRoutes("CurrentCreatorNavRoute")

    //event
    object EventListNavRoute : NavRoutes("EventListNavRoute")
    object CurrentEventNavRoute : NavRoutes("CurrentEventNavRoute")

    //series
    object SeriesListNavRoute : NavRoutes("SeriesListNavRoute")
    object CurrentSeriesNavRoute : NavRoutes("CurrentSeriesNavRoute")
}