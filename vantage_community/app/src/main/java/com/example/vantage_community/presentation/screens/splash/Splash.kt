package com.example.vantage_community.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vantage_community.R
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * Begrüßungsbildschirm
 */
@Composable
fun SplashScreen(
    navController: NavHostController
){
    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navController.popBackStack()
        navController.navigate(Screen.Anmeldung.route)
    }

    Splash(degrees = degrees.value)



}


@Composable
fun Splash(degrees: Float){
    
    Box( modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
            Image(painter = painterResource(id =  R.drawable.ic_logo), contentDescription = "logo"  ,
                modifier = Modifier
                    .rotate(degrees = degrees)
                    .size(100.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),            )


    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview()
@Composable
fun splashprev() {
    Vantage_CommunityTheme() {
        Splash(0f)

    }
}

