package com.example.vantage_community.presentation.screens.einlagerer.stellplatzsuche

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.R
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Lager
import com.example.vantage_community.domain.model.Service
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.bottomnav
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme


/**
 *  Liste alle Verfügbare Lager im bestimmten Ort Bildschirm
 */
@Composable
fun Stellplatzsuche(
    navController: NavHostController
) {



    val x = 5

    Scaffold(
        bottomBar = { bottomnav(navController = navController) },

    ) {
        Vantage_CommunityTheme() {

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                Column(modifier = Modifier.align(Alignment.TopCenter)) {
                    MyContent()

                    LazyColumn(modifier = Modifier.padding(bottom = 45.dp)) {

                        items(database.getLager(mSelectedTexto.value)) { lager ->

                            stellplatzy(
                                serivezeiten = lager.serivezeiten,
                                Ort = lager.Ort
                            ) { navController.navigate(Screen.Detailsinfo.passLagerId(lager.LagerID)) }

                        }


                    }
                }


            }
        }
    }

}




    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun stellplatzy(
        serivezeiten: String,
        Ort: String,
        x :() -> Unit
    ) {
    var id = R.drawable.park2
        if (Ort == "Gießen"){
            id =R.drawable.park
        }
        Card(modifier = Modifier.padding(20.dp), onClick =x ) {


                Column(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {
                    Image(
                        painter = painterResource(id = id), contentDescription = "logo",
                        modifier = Modifier
                            .fillMaxWidth()
                        , contentScale = ContentScale.Crop

                    )
                    Box(modifier = Modifier.padding(20.dp)){
                        Row() {
                            Column(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {

                                Text(
                                    text = "Servicezeiten : ",
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colors.secondary,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "$serivezeiten", fontSize = 20.sp)
                            }
                              Spacer(modifier = Modifier.padding(20.dp))
                            Column(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {

                                Text(text = "Ort :"  , fontSize = 20.sp, color = MaterialTheme.colors.secondary, fontWeight = FontWeight.Bold)
                                Text(text = "$Ort"  , fontSize = 20.sp)
                            }
                            }


                      //  Text(text = "Services :")
                       // angeboteneServices.forEach { service ->
                       //     Text(text = "${service.name} , Preis : ${service.preis}")
                     //   }
                       // Text(text = "Anzahl stellplätze : $Anzahlstellplaetze")

                    }
}




            }



    }





