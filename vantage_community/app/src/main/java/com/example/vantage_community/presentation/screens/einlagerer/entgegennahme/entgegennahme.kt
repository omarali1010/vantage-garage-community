package com.example.vantage_community.presentation.screens.einlagerer.entgegennahme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Nachricht
import com.example.vantage_community.domain.model.Status
import com.example.vantage_community.domain.model.Termin
import com.example.vantage_community.domain.model.Type
import com.example.vantage_community.navigation.Screen

/**
 *  Fahrzeug Entgegennahme Bildschirm
 */
@Composable
fun entgegennahme(fahgesttetllnummer: Int? ,navController: NavHostController) {


    entgegenform(navController,database.lagerhalter.Termine, fahgesttetllnummer!! )

}


@Composable
fun entgegenform(navController: NavHostController,termine : MutableList<Termin>,fahgesttetllnummer : Int) {
    lateinit var  postfach : Nachricht

    Box(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxSize()){
Column() {
    Text(
        text = "Termine : ",
        fontSize = 20.sp,
        color = MaterialTheme.colors.primaryVariant,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(10.dp)
    )
    termine.forEach {termin ->
          if (termin.status==Status.frei){
              Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                  Button(
                      onClick = {


                         termin.status =Status.übermittlelt
                          postfach = Nachricht(database.lagerhalter.postfach.size, "Bestätigen Sie bitte die Termin für Fahrzeug entgegennahme von \n\n ${database.einlagerer1.nachname},${database.einlagerer1.vorname} \n" +
                                  "\n" +
                                  "\n" +
                                  "Fahrzeug :\n" +
                                  " Fahrgestellnummer :${database.getfahrzeug(fahgesttetllnummer).fahrgestellnummer} \n" +
                                  " Marke : ${database.getfahrzeug(fahgesttetllnummer).marke} \n" +
                                  " Termin am ${termin.Datum}  ${termin.Zeit} ",true, Type.Entgegennahme)
                       postfach.fahrgestellnummer = fahgesttetllnummer
                          database.einlagerer1.postfach.add(
                              Nachricht(
                              database.einlagerer1.postfach.size,"Termin für die Fahrzeug : \n fahrgestellnummer :${
                                      database.getfahrzeug(
                                          fahgesttetllnummer
                                      ).fahrgestellnummer
                                  } \n  ist an die Lagerhalter übermittelt \n\n Termin am ${termin.Datum}  ${termin.Zeit}",false, Type.Entgegennahme))
                          database.lagerhalter.postfach.add( postfach)
                          navController.navigate(Screen.Profil.route)},
                      shape = RoundedCornerShape(50.dp),
                      modifier = Modifier.padding(10.dp)
                          .fillMaxWidth()
                          .height(50.dp).border(5.dp,MaterialTheme.colors.primaryVariant,
                              RoundedCornerShape(50.dp)
                          )


                  ){
                      Text(text = "${termin.Datum}    ${termin.Zeit}")
                  }
          }

        }

    }

}


    }


}