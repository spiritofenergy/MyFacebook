package com.kodex.myfacebook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodex.myfacebook.screens.HomeScreen

sealed class  NavRoute(val route: String){
    object HomeScreen: NavRoute("home_screen")
    object Add : NavRoute("add_screen")
    object Main: NavRoute("main_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NavigationFacebook (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.HomeScreen.route){
        composable(NavRoute.HomeScreen.route){ HomeScreen(navController = navController)}
    }
}