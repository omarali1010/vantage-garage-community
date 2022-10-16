package com.example.vantage_community.presentation.screens.einlagerer.postfach

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Nachricht
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.bottomnav
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * Einlagerer Postfach Bildschirm
 */
@Composable
fun Postfach(
    navController: NavHostController
){

    val postfach = remember {

        mutableStateOf(database.einlagerer1.postfach)
    }

    Scaffold(
        bottomBar = { bottomnav(navController = navController) }
    ) {
        Vantage_CommunityTheme() {

            Box( modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize()
                ,
                contentAlignment = Alignment.Center)
            {
                Column(modifier = Modifier.padding(bottom = 55.dp)
                    .align(Alignment.TopCenter)
                    .verticalScroll(
                        rememberScrollState()
                    )    ,   verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Postfach", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))


                    postfach.value.forEach {
                    post ->

                    massege(navController,post)
                }

                }




            }
        }
    }




}

@Composable
fun massege(  navController: NavHostController,post : Nachricht) {
    Card(modifier = Modifier.padding(20.dp)) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Column() {
                Text(text = post.Nachricht)
                Row(modifier = Modifier.fillMaxWidth()) {

                    if (post.bestätigung) {
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
                            Text(text = "Bestätigen")
                        }
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
                            Text(text = "Ablehnen")
                        }
                    } else {
                        Button(
                            onClick = { database.einlagerer1.postfach.remove(post)
                                     navController.navigate(Screen.Postfach.route)
                                      },
                            modifier = Modifier.padding(10.dp).fillMaxWidth()
                        ) {
                            Text(text = "Verstanden")
                        }
                    }
                }

            }
        }
    }
}
