package com.example.vantage_community.presentation.screens.lagerhalter.neuelager

import android.util.Log
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vantage_community.data.local.Database
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Lager
import com.example.vantage_community.domain.model.Service
import com.example.vantage_community.navigation.Screen


/**
 * neue Lager hinzufügen Bildschirm
 */
@Composable
fun neuelager(navController: NavHostController) {

 var x = 0
    var lager : Lager
    val services :MutableList<Service> = emptyList<Service>().toMutableList()
    Column(
        modifier = Modifier.background(MaterialTheme.colors.primary).fillMaxSize()  .verticalScroll(
            rememberScrollState()
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val ort = remember { mutableStateOf(TextFieldValue()) }
        val anzahlstellplatze = remember { mutableStateOf(TextFieldValue()) }
        val servicess = remember { mutableStateOf(TextFieldValue()) }
        val preise = remember { mutableStateOf(TextFieldValue()) }
        val servicezeit = remember { mutableStateOf(TextFieldValue()) }
        val adress = remember { mutableStateOf(TextFieldValue()) }
        val plz = remember { mutableStateOf(TextFieldValue()) }


        Text(text = "Neues Lager", style = TextStyle(fontSize = 70.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))

        Spacer(modifier = Modifier.height(70.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Ort") },
            value = ort.value,
            onValueChange = { ort.value = it },
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = preise.value,
            onValueChange = { preise.value = it })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "Straße ,Hausnummer") },
            value = adress.value,
            onValueChange = { adress.value = it })
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
            label = { Text(text = "PLZ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = plz.value,
            onValueChange = { plz.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {

                    val yy =   preise.value.text.split(",")
                    if (!servicess.value.text.isNullOrEmpty() && yy.size == servicess.value.text.split(",").size){
                        servicess.value.text.split(",").forEach {
                                service->

                            services.add(Service(x,yy[x].toInt().toDouble(),service))






                            x++
                        }
                        lager = Lager(database.lagerhalter.lagers.size+1,servicezeit.value.text,services,  anzahlstellplatze.value.text.toInt(),ort.value.text,adress.value.text, plz.value.text.toInt(),
                            database.lagerhalter.vorname +" "+ database.lagerhalter.nachname)

                        database.lagerhalter.lagers.add(lager)
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
                Text(text = "Hinzufügen")

            }
        }

        Spacer(modifier = Modifier.height(80.dp))
}

}