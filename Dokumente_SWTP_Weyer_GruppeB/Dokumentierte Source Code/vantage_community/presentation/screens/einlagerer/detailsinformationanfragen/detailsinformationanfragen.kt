package com.example.vantage_community.presentation.screens.einlagerer.detailsinformationanfragen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.R
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Lager
import com.example.vantage_community.domain.model.Nachricht
import com.example.vantage_community.domain.model.Service
import com.example.vantage_community.domain.model.Type
import com.example.vantage_community.navigation.Screen

/**
 *  Detailsinformation eine Bestimmte Lager Bildschirm mit die Option Service zu buchen oder Detailsinformationanfrage zu stellen
 */
@Composable
fun detailsinfo(lager : Int?,navController: NavHostController) {

    var  lagerer : Lager
    if (lager != null) {
          lagerer=  database.getLagerfromID(lager)
        details(lager,navController,serivezeiten = "${lagerer.serivezeiten}", angeboteneServices = lagerer.angeboteneServices, Anzahlstellplaetze = lagerer.Anzahlstellplaetze, Ort =lagerer.Ort )

    }
    else{
        Text(text = "Error from the server to get the Lager")
    }

}


@Composable
fun details(lager : Int?,navController: NavHostController,serivezeiten : String, angeboteneServices : MutableList<Service>, Anzahlstellplaetze:Int, Ort : String) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
      lateinit var  postfach :Nachricht
    Box(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxSize()){


        Box(modifier = Modifier
            .fillMaxWidth()

            .padding(bottom = 50.dp)
            .background(MaterialTheme.colors.primary)){

            Column(  verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())) {
                Image(painter = painterResource(id = R.drawable.park2),contentScale = ContentScale.Crop, contentDescription = "photo",modifier = Modifier
                    .padding(bottom = 15.dp)
                    .fillMaxWidth())


                 Text(text = "Servicezeit : $serivezeiten", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )
                 Text(text = "Anzahl Stellplätze: $Anzahlstellplaetze", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )
                 Text(text = "Ort : $Ort", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )

                 Spacer(modifier = Modifier.padding(bottom = 60.dp))

Box(modifier = Modifier
    .padding(20.dp)
    .border(3.dp, MaterialTheme.colors.secondary, RoundedCornerShape(3.dp))){
    Column() {
        Text(text =  "Anfrage der Detailinformationen mit optionalen zusätzlichen Fragen", style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) , modifier = Modifier.padding(10.dp))

        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
                .padding(10.dp),
            label = { Text(text = "Zusätzliche Fragen") },

            )
        Spacer(modifier = Modifier.padding(bottom = 10.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {

                    database.einlagerer1.postfach.add(
                        Nachricht(
                            database.einlagerer1.postfach.size,"Detailinformationsanfrage wurde an den Lagerhalter geschickt",false, Type.detailsinformationanfrage)
                    )
    postfach =    Nachricht(
        database.einlagerer1.postfach.size,"Einlagerer bittet Sie Ihre Detailinformationen zu übermitteln und hat zusätzlich folgende Fragen: \n ${textState.value.text}",false, Type.detailsinformationanfrage)
                    if (lager != null) {
                        postfach.lagerID = lager
                    }
                    database.lagerhalter.postfach.add(postfach)


                    navController.navigate(Screen.Stellplatzsuche.route) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        5.dp, MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(50.dp)
                    )


            ){
                Text(text = "Schicken")

            }

        }
    }

}

                Spacer(modifier = Modifier.padding(bottom = 40.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {navController.navigate(Screen.Servicebuchen.passLagerId(lager!!)) },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                5.dp, MaterialTheme.colors.secondary,
                                RoundedCornerShape(50.dp)
                            )


                    ){
                        Text(text = "Service Buchen")

                    }

                    Spacer(modifier = Modifier.padding(bottom = 20.dp))


                }

            }





        }






    }

}