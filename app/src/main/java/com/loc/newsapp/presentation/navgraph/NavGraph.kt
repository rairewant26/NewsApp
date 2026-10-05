package com.loc.newsapp.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.presentation.home.HomeScreen
import com.loc.newsapp.presentation.home.HomeViewModel
import com.loc.newsapp.presentation.news_navigator.NewsNavigator
import com.loc.newsapp.presentation.onboarding.OnBoardingViewModel
import com.loc.newsapp.presentation.onboarding.OnboardingScreen
import com.loc.newsapp.presentation.search.SearchScreen
import com.loc.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String,
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnboardingScreen.route
        ){
            composable(Route.OnboardingScreen.route){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnboardingScreen(
                    event = viewModel::OnEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                NewsNavigator()
            }
        }
    }
}