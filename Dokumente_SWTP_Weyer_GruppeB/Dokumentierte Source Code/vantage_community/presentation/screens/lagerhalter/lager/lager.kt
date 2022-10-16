package com.example.vantage_community.presentation.screens.lagerhalter.lager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.R
import com.example.vantage_community.data.local.Database
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Service
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.einlagerer.stellplatzsuche.MyContent
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.bottomnavLagerhalter
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * eine Liste alle Lager bestimmte Lagerhalter Bildschirm
 */
@Composable
fun LagerLagerhalter(
    navController: NavHostController
){


    val lagerhalter = database.lagerhalter
    val x = 5

    Scaffold(
        bottomBar = { bottomnavLagerhalter(navController = navController)



        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.Neuelager.route)},
                backgroundColor = MaterialTheme.colors.primarySurface,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )
        }
    ) {
        Vantage_CommunityTheme() {

            Box( modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize()
                ,
                contentAlignment = Alignment.Center)
            {

Column(   verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.height(10.dp))

    Text(text = "Lager", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))
    LazyColumn(modifier = Modifier.padding(bottom = 45.dp)) {

        items(lagerhalter.lagers){lager ->

            stellplatzy(
                lager.LagerID,
                navController =navController,
                lagerHalter = lagerhalter.vorname,
                serivezeiten = lager.serivezeiten,
                angeboteneServices = lager.angeboteneServices,
                Anzahlstellplaetze = lager.Anzahlstellplaetze,
                Ort =lager.Ort
            )

        }


    }
}



            }
        }
    }





}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun stellplatz(lagerID : Int ,navController: NavHostController,lagerHalter: String,  serivezeiten : String,  angeboteneServices : MutableList<Service>,  Anzahlstellplaetze:Int,  Ort : String) {

    Card(modifier = Modifier.padding(20.dp), onClick = {navController.navigate(Screen.lagerandern.passLagerId(lagerID))}) {
        Row(modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxWidth()) {
            Image(painter = painterResource(id =  R.drawable.park2), contentDescription = "logo"  ,
                modifier = Modifier
                    .size(100.dp)
            )
            Column() {
                Text(text = "LagerID :$lagerID ")

                Text(text = "Servicezeiten : ${serivezeiten}")
                Text(text = "Services :")
                angeboteneServices.forEach { service ->
                    Text(text = "${service.name} , Preis : ${service.preis}")
                }
                Text(text = "Anzahl Stellplätze : $Anzahlstellplaetze")
                Text(text = "Ort : $Ort")

            }


        }
    }


}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun stellplatzy(
    lagerID : Int ,navController: NavHostController,lagerHalter: String,  serivezeiten : String,  angeboteneServices : MutableList<Service>,  Anzahlstellplaetze:Int,  Ort : String,

) {

    Card(modifier = Modifier.padding(20.dp), onClick = { navController.navigate(Screen.lagerandern.passLagerId(lagerID)) } ) {


        Column(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {
            Image(
                painter = painterResource(id = R.drawable.park2), contentDescription = "logo",
                modifier = Modifier
                    .fillMaxWidth()
                , contentScale = ContentScale.Crop

            )
            Box(modifier = Modifier.padding(20.dp)){
                    Column(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {

                        Text(
                            text = "Besitzer : ",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "$lagerHalter", fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(10.dp))

                        Text(
                            text = "LagerID : ",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "$lagerID", fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(10.dp))

                        Text(
                            text = "Servicezeiten : ",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "$serivezeiten", fontSize = 20.sp)

                    Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = "Services : ",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                angeboteneServices.forEach { service ->
                    Text(text = "${service.name} , Preis : ${service.preis} €")
                }

                        Spacer(modifier = Modifier.padding(10.dp))

                        Text(
                            text = "Anzahl Stellplätze :",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                Text(text = "$Anzahlstellplaetze")
                        Spacer(modifier = Modifier.padding(10.dp))

                        Text(
                            text = "Ort :",
                            fontSize = 20.sp,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = "$Ort"  , fontSize = 20.sp)

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