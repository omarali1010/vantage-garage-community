package com.example.vantage_community

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.navigation.SetupNavGraph
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.MainScreenView
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.MainScreenViewLagerhalter
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * Haupt klasse der Android App
 */
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vantage_CommunityTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
                  }
        }
    }
}


