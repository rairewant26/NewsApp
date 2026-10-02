package com.loc.newsapp.presentation.navgraph

sealed class Route(
    val route :String
) {

    object OnboardingScreen: Route(route = "OnboardingScreen")
    object HomeScreen: Route(route = "HomeScreen")
    object SearchScreen: Route(route = "SearchScreen")
    object BookmarkScreen: Route(route = "BookmarksScreen")
    object DetailsScreen: Route(route = "DetailsScreen")
    object AppStartNavigation: Route(route = "AppStartNavigation")
    object NewsNavigation: Route(route = "Newsnavigation")
    object NewsNavigatorScreen: Route(route = "NewsNavigator")

}