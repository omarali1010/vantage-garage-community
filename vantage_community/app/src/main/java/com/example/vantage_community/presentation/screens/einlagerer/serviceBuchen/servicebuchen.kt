package com.example.vantage_community.presentation.screens.einlagerer.serviceBuchen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Nachricht
import com.example.vantage_community.domain.model.Type
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * Einlagere Service buchen Bildschirm
 */
@Composable
fun servicebuchen(lagerID : Int? , navController: NavHostController) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val fahrzeuggestellnummer = remember { mutableStateOf(TextFieldValue()) }
    lateinit var  postfach : Nachricht
     var ausgewählteservices :StringBuilder  =StringBuilder()
    val lager = database.getLagerfromID(lagerID!!)
    var servicesausgewählt : MutableList<Boolean> = listOf<Boolean>().toMutableList()
Box(modifier = Modifier
    .background(MaterialTheme.colors.primary)
    .fillMaxSize()
    .padding(20.dp)){
Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    Text(text = "Ort : ${lager.Ort}", color = MaterialTheme.colors.onPrimary)
    Text(
        text = "Anzahl Stellplätze : ${lager.Anzahlstellplaetze}",
        color = MaterialTheme.colors.onPrimary
    )
    Text(text = "Servicezeiten : ${lager.serivezeiten}", color = MaterialTheme.colors.onPrimary)
    Text(text = "Services:", color = MaterialTheme.colors.secondary, style = TextStyle(fontWeight = FontWeight.Bold), modifier = Modifier.padding(top = 10.dp))

    lager.angeboteneServices.forEach { angebot ->
        Text(
            text = "${angebot.name}    Preis : ${angebot.preis}",
            color = MaterialTheme.colors.onPrimary
        )
    }


    Spacer(modifier = Modifier.height(40.dp))

        Box(modifier = Modifier
            .border(2.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(2.dp))){

Column() {
    Spacer(modifier = Modifier.padding(bottom = 60.dp))
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 100.dp)
            .padding(end = 10.dp, start = 10.dp),
        label = { Text(text = "Services") },

        )
    Spacer(modifier = Modifier.padding(bottom = 60.dp))
    TextField(
        value = fahrzeuggestellnummer.value,
        onValueChange = { fahrzeuggestellnummer.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        label = { Text(text = "Fahrgestellnummer") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    )

}


            Spacer(modifier = Modifier.height(80.dp))
}


    TextButton(onClick = {
        if(fahrzeuggestellnummer.value.text.isNotEmpty()){
            postfach = Nachricht(database.lagerhalter.postfach.size, "Bestätigen Sie Bitte die Buchung  von \n${database.getfahrzeugbesitzer(fahrzeuggestellnummer.value.text.toInt()).nachname},${database.getfahrzeugbesitzer(fahrzeuggestellnummer.value.text.toInt()).vorname}:\n\nFahrzeug :\n fahrgestellnummer :${database.getfahrzeug(fahrzeuggestellnummer.value.text.toInt()).fahrgestellnummer} \n Marke : ${database.getfahrzeug(fahrzeuggestellnummer.value.text.toInt()).marke} \n an Lager :${lager.LagerID}  \n Services :${textState.value.text} \n ${ausgewählteservices.toString()}",true, Type.buchungübermittelt)
            postfach.fahrgestellnummer =fahrzeuggestellnummer.value.text.toInt()

        }
        else{
            postfach = Nachricht(database.lagerhalter.postfach.size, "Bestätigen Sie Bitte die Buchung  von \n${database.getfahrzeugbesitzer(34234).nachname},${database.getfahrzeugbesitzer(34234).vorname}:\n\nFahrzeug :\n fahrgestellnummer :${database.getfahrzeug(34234).fahrgestellnummer} \n Marke : ${database.getfahrzeug(34234).marke} \n an Lager :${lager.LagerID}  \n Services :${textState.value.text} \n ${ausgewählteservices.toString()}",true, Type.buchungübermittelt)
            postfach.fahrgestellnummer =34234
        }
        database.einlagerer1.postfach.add(
            Nachricht(
                database.einlagerer1.postfach.size,"Servicebuchung wurde an den Lagerhalter übermittelt",false, Type.buchungübermittelt)
        )
        database.lagerhalter.postfach.add( postfach )


        navController.navigate(Screen.Stellplatzsuche.route) },
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)) {
        Text(text = "Service Buchen")

    }

}





    }



}





@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun buch() {

    Vantage_CommunityTheme() {
        servicebuchen(lagerID = 1, navController = rememberNavController())
    }

}