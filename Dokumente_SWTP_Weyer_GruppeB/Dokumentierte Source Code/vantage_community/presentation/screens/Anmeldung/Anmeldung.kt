package com.example.vantage_community.presentation.screens.Anmeldung

import android.content.res.Configuration
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.splash.Splash
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme


/**
 * Jetpack Compose funktion für Die Anmeldung Bildschirm
 */
@Composable
fun AnmeldungScreen( navController: NavHostController){

    var enabled by remember {
        // 2.
        mutableStateOf(true)
    }
    var x by remember {
        // 2.
        mutableStateOf(0)
    }


    enabled = x != 4
    var button : String = ""
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.primary)) {

    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Login", style = TextStyle(fontSize = 70.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Benutzername") },
            value = username.value,
            onValueChange = { username.value = it },
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Passwort") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {

                    if (username.value.text == "123" && password.value.text == "123"){
                        navController.navigate(Screen.Profil.route)
                    }
                    else if(username.value.text == "456"  && password.value.text == "456"){
                        navController.navigate(Screen.ProfilLagerhalter.route)

                    }
                    else{
                           x++
                    }

                    },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        5.dp, MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(50.dp)
                    )


            , enabled = enabled)
            {
                Text(text = "Login")

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(

            text = AnnotatedString(button),
            onClick = { },
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = MaterialTheme.colors.onPrimary
            )
        )
    }

}

