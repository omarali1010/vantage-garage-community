package com.example.vantage_community.presentation.screens.lagerhalter.postfach

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.*
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.bottomnavLagerhalter
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 *  Lagerhalter Postfach Bildschirm
 */
@Composable
fun PostfachLagerhalter(
    navController: NavHostController
){

    Scaffold(
        bottomBar = { bottomnavLagerhalter(navController = navController) }
    ) {
        Vantage_CommunityTheme() {

            Box( modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize()
                ,
                contentAlignment = Alignment.Center)
            {
                Column(modifier = Modifier.padding(bottom = 70.dp)
                    .align(Alignment.TopCenter)
                    .verticalScroll(
                        rememberScrollState()
                    )    ,   verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Spacer(modifier =Modifier.height(10.dp))
                    Text(text = "Postfach", style = TextStyle(fontSize = 70.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))


                    database.lagerhalter.postfach.forEach {
                            post ->

                    massege(navController,post
                        )
                    }

                }




            }
        }
    }





}



@Composable
fun massege(navController: NavHostController,post : Nachricht) {
    val lager :Lager = database.getLagerfromID(post.lagerID)
    val textState = remember { mutableStateOf(TextFieldValue()) }
    var type1 : Type = Type.error
    var type2 : Type = Type.error

    Card(modifier = Modifier.padding(20.dp)) {
        Box(modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxWidth()
            .padding(20.dp)) {

  Column() {
      Text(text = post.Nachricht)
      Row(modifier = Modifier.fillMaxWidth()) {

        if (post.bestätigung ){
           if (post.type ==Type.Entgegennahme){
               type1 = Type.Entgegennahmebestätigunganfrage
               type2 = Type.EntgegennahmeAblehnunuganfrage
           }
           else if (post.type ==Type.buchungübermittelt){
               type1 = Type.buchungbestätigen
               type2 = Type.buchungablehnung
           }

            Button(onClick = { bestatigung(type1,post.fahrgestellnummer)
                database.lagerhalter.postfach.remove(post)
                navController.navigate(Screen.PostfachLagerhalter.route)
                             }, modifier = Modifier.padding(10.dp)) {
                Text(text ="Bestätigen" )
            }
            Button(onClick = {bestatigung(type2,post.fahrgestellnummer)
                database.lagerhalter.postfach.remove(post)
                navController.navigate(Screen.PostfachLagerhalter.route)
                             }, modifier = Modifier.padding(10.dp)) {
                Text(text ="Ablehnen" )
            }
          }

          else{
              Column() {
                  if (post.type == Type.detailsinformationanfrage){
                      TextField(
                          value = textState.value,
                          onValueChange = { textState.value = it },
                          modifier = Modifier
                              .fillMaxWidth()
                              .defaultMinSize(minHeight = 100.dp)
                              .padding(end = 10.dp, start = 10.dp),
                          label = { Text(text = "Antwort") },

                          )

                      Button(onClick = {
                          database.lagerhalter.postfach.remove(post)
                          navController.navigate(Screen.PostfachLagerhalter.route)
                          database.einlagerer1.postfach.add(Nachricht(database.einlagerer1.postfach.size,"Detailsinformationen : \n\n Besitzer : \n${lager.besitzer}\nAdress : \n${lager.adress}\n${lager.plz}\n\nAntwort von Lagerhalter : \n ${textState.value.text}",false,Type.detailsinformationantwort))

                      }, modifier = Modifier
                          .padding(10.dp)
                          .fillMaxWidth()) {
                          Text(text ="Freischalten" )
                      }
                  }else{
                      Button(onClick = {
                          database.lagerhalter.postfach.remove(post)
                          navController.navigate(Screen.PostfachLagerhalter.route)


                      }, modifier = Modifier
                          .padding(10.dp)
                          .fillMaxWidth()) {
                          Text(text ="Verstanden" )
                      }
                  }


              }



        }
      }

  }


        }
    }
}



fun bestatigung(type :Type,fahrzeugnummer :Int =34234){
var fahrzeug = database.getfahrzeug(fahrzeugnummer)
    if(type ==Type.Entgegennahmebestätigunganfrage){
        database.einlagerer1.postfach.add(Nachricht(database.einlagerer1.postfach.size,"Ihre Fahrzeug Entgegennahme für fahrzeug mit fahrgestellnummer : ${fahrzeug.fahrgestellnummer} würde bestätigt ",false,Type.bestätigt))
    }
    else if(type ==Type.EntgegennahmeAblehnunuganfrage){
            database.einlagerer1.postfach.add(Nachricht(database.einlagerer1.postfach.size,"Ihre Fahrzeug Entgegennahme für fahrzeug mit fahrgestellnummer : ${fahrzeug.fahrgestellnummer} würde Abgelehnt",false,Type.abgelehnt))
        }
    else if (type==Type.buchungbestätigen){
        database.einlagerer1.postfach.add(Nachricht(database.einlagerer1.postfach.size,"Service Buchung für fahrzeug mit fahrgestellnummer : ${fahrzeug.fahrgestellnummer} wurde bestätigt",false,Type.bestätigt))

    }
    else if (type==Type.buchungablehnung){
        database.einlagerer1.postfach.add(Nachricht(database.einlagerer1.postfach.size,"Service Buchung für fahrzeug mit fahrgestellnummer : ${fahrzeug.fahrgestellnummer}wurde abgelehnt",false,Type.abgelehnt))

    }
}
