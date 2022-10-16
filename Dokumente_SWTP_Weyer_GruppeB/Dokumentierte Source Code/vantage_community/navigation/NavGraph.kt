package com.example.vantage_community.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.vantage_community.presentation.screens.Anmeldung.AnmeldungScreen
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.MainScreenView
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.bottomnav
import com.example.vantage_community.presentation.screens.einlagerer.detailsinformationanfragen.detailsinfo
import com.example.vantage_community.presentation.screens.einlagerer.entgegennahme.entgegennahme
import com.example.vantage_community.presentation.screens.einlagerer.postfach.Postfach
import com.example.vantage_community.presentation.screens.einlagerer.profil.ProfilEinlager
import com.example.vantage_community.presentation.screens.einlagerer.serviceBuchen.servicebuchen
import com.example.vantage_community.presentation.screens.einlagerer.stellplatzsuche.Stellplatzsuche
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.MainScreenViewLagerhalter
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.bottomnavLagerhalter
import com.example.vantage_community.presentation.screens.lagerhalter.lager.LagerLagerhalter
import com.example.vantage_community.presentation.screens.lagerhalter.lagerandern.lagerandern
import com.example.vantage_community.presentation.screens.lagerhalter.neuelager.neuelager
import com.example.vantage_community.presentation.screens.lagerhalter.postfach.PostfachLagerhalter
import com.example.vantage_community.presentation.screens.lagerhalter.profil.ProfilLagerhalter
import com.example.vantage_community.presentation.screens.splash.SplashScreen

/**
 * Jetpack compose Funktion um die navigation zu kontrollieren
 */
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(

        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Anmeldung.route) {
            AnmeldungScreen(navController = navController)
        }

        composable(route = Screen.Postfach.route) {
            Postfach(navController = navController)
        }

        composable(route = Screen.Profil.route) {
            ProfilEinlager(navController = navController)
        }

        composable(route = Screen.ProfilLagerhalter.route) {
            ProfilLagerhalter(navController = navController)
        }

        composable(route = Screen.LagerLagerhalter.route) {
            LagerLagerhalter(navController = navController)
        }

        composable(route = Screen.PostfachLagerhalter.route) {
            PostfachLagerhalter(navController = navController)
        }
        composable(route = Screen.BottomnavEinlagerer.route) {
            MainScreenView()
        }
        composable(route = Screen.BottomnavLagerhalter.route) {
            MainScreenViewLagerhalter()
        }
        composable(route = Screen.Neuelager.route) {
            neuelager(navController = navController)
        }

        composable(route = Screen.Stellplatzsuche.route) {
            Stellplatzsuche(navController = navController)
        }




        composable(
            route = Screen.Detailsinfo.route ,
            arguments = listOf(navArgument("lager") {
                type = NavType.IntType
            })
        ) {
            detailsinfo(lager = it.arguments?.getInt("lager"), navController = navController)
        }


        composable(
            route = Screen.lagerandern.route ,
            arguments = listOf(navArgument("lager") {
                type = NavType.IntType
            })
        ) {
            lagerandern(lagerID = it.arguments?.getInt("lager"), navController = navController)
        }


        composable(
            route = Screen.Servicebuchen.route ,
            arguments = listOf(navArgument("lager") {
                type = NavType.IntType
            })
        ) {
            servicebuchen(lagerID = it.arguments?.getInt("lager"), navController = navController)
        }


        composable(
            route = Screen.Entgegennahme.route ,
            arguments = listOf(navArgument("fahrzeugid") {
                type = NavType.IntType
            })
        ) {
            entgegennahme(fahgesttetllnummer = it.arguments?.getInt("fahrzeugid"), navController = navController)
        }

    }
}