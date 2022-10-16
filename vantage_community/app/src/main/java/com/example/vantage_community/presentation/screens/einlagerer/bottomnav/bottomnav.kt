package com.example.vantage_community.presentation.screens.einlagerer.bottomnav

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.R
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.navigation.SetupNavGraph


/**
 * Einlagerer Bodennavigaton GUI
 */
@Composable
fun bottomnav(navController: NavController) {

    var iconid :Int =R.drawable.ic_baseline_home_24
    var iconid2 :Int =R.drawable.ic_baseline_garage_24
    var iconid3 :Int =R.drawable.ic_baseline_local_post_office_24
    val items = listOf(
        Screen.Profil,
        Screen.Postfach,
        Screen.Stellplatzsuche
    )

    BottomNavigation(

    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            if (item.route ==Screen.Stellplatzsuche.route){
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
            if (item.route ==Screen.Profil.route){
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
            if (item.route ==Screen.Postfach.route){
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
fun MainScreenView( ){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { bottomnav(navController = navController) }
    ) {

        SetupNavGraph(navController)

    }
}
                


        

