package com.example.vantage_community.presentation.screens.lagerhalter.bottomnav

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.R
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.navigation.SetupNavGraph

/**
 * Lagerhalter Bodennavigaton GUI
 */
@Composable
fun bottomnavLagerhalter(navController: NavController) {

    var iconid :Int =R.drawable.ic_baseline_home_24
    var iconid2 :Int =R.drawable.ic_baseline_garage_24
    var iconid3 :Int =R.drawable.ic_baseline_local_post_office_24
    val items = listOf(
        Screen.ProfilLagerhalter,
        Screen.PostfachLagerhalter,
        Screen.LagerLagerhalter
    )

    BottomNavigation() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            if (item.route ==Screen.LagerLagerhalter.route){
                BottomNavigationItem(
                    icon ={ Icon(painterResource(id = iconid2), contentDescription = item.route) },

                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                )
            }
            if (item.route ==Screen.ProfilLagerhalter.route){
                BottomNavigationItem(
                    icon ={ Icon(painterResource(id = iconid), contentDescription = item.route) },

                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                )
            }
            if (item.route ==Screen.PostfachLagerhalter.route){
                BottomNavigationItem(
                    icon ={ Icon(painterResource(id = iconid3), contentDescription = item.route) },

                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                )
            }


        }
    }
}


@Composable
fun MainScreenViewLagerhalter(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { bottomnavLagerhalter(navController = navController) }
    ) {

        SetupNavGraph(navController = navController)
    }
}