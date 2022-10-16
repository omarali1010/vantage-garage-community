package com.example.vantage_community.presentation.screens.lagerhalter.lagerandern

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Lager
import com.example.vantage_community.domain.model.Service
import com.example.vantage_community.navigation.Screen

/**
 * Lager information ändern Bildschirm
 */
@Composable
fun lagerandern(lagerID :Int?,navController: NavHostController) {
    var servicesname :StringBuilder =StringBuilder()
    var prefix : String = ""
    var preis :StringBuilder =StringBuilder()
    var prefix2 : String = ""

    var x = 0
    var lager1: Lager = lagerID?.let { database.getLagerfromID(it) }  ?: database.lager1

    lager1.angeboteneServices.forEach {
            service ->
        servicesname.append("$prefix")
        servicesname.append("${service.name}")
        prefix =","

    }

    lager1.angeboteneServices.forEach {
            service ->
        preis.append("$prefix2")
        preis.append("${service.preis}")
        prefix2 =","

    }

    val services :MutableList<Service> = emptyList<Service>().toMutableList()
    Column(
        modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxSize()  .verticalScroll(
            rememberScrollState()
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var ort = remember { mutableStateOf(TextFieldValue("${lager1.Ort}")) }
        val anzahlstellplatze = remember { mutableStateOf(TextFieldValue("${lager1.Anzahlstellplaetze}")) }

        val servicess = remember { mutableStateOf(TextFieldValue("$servicesname")) }
        val preise = remember { mutableStateOf(TextFieldValue("$preis"))}
        val servicezeit = remember { mutableStateOf(TextFieldValue("${lager1.serivezeiten}")) }


        Text(text = "Lager ändern", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))

        Spacer(modifier = Modifier.height(70.dp))
        TextField(

            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Ort") },
            value = ort.value,
            onValueChange = { ort.value = it  },
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Servicezeit") },
            value = servicezeit.value,
            onValueChange = { servicezeit.value = it },
        )



        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Anzahl Stellplätze") },
            value = anzahlstellplatze.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { anzahlstellplatze.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Services(getrennt mit ,)") },
            value = servicess.value,
            onValueChange = { servicess.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Preise der Services(getrennt mit ,)") },
            value = preise.value,
            onValueChange = { preise.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {

                    val yy =   preise.value.text.split(",")
                    servicess.value.text.split(",").forEach {
                            service->
                        services.add(Service(x,yy[x].toDouble(),service))


                        x++
                    }

                    lager1.Ort = ort.value.text
                    lager1.serivezeiten = servicezeit.value.text
                    lager1.angeboteneServices = services
                    lager1.Anzahlstellplaetze = anzahlstellplatze.value.text.toInt()

                    database.lagerhalter.lagers.forEach {
                        lager ->
                        if (lager.LagerID == lager1.LagerID){
                            lager.Ort =lager1.Ort
                            lager.Anzahlstellplaetze = lager1.Anzahlstellplaetze
                            lager.serivezeiten = lager1.serivezeiten
                            lager.angeboteneServices = lager1.angeboteneServices
                        }
                    }

                    navController.navigate(Screen.LagerLagerhalter.route)
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        5.dp, MaterialTheme.colors.primaryVariant,
                        RoundedCornerShape(50.dp)
                    )


            ){
                Text(text = "Speichern")

            }
        }

        Spacer(modifier = Modifier.height(80.dp))
    }

}