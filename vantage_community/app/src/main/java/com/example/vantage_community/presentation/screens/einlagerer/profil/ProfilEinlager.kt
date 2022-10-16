package com.example.vantage_community.presentation.screens.einlagerer.profil

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.R
import com.example.vantage_community.data.local.Database
import com.example.vantage_community.data.local.database
import com.example.vantage_community.domain.model.Status
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.einlagerer.bottomnav.bottomnav
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme


/**
 * Einlagerer Profil Bildschirm
 */
@Composable
fun ProfilEinlager(
    navController: NavHostController


){
    Scaffold(
        bottomBar = { bottomnav(navController = navController) }
    ) {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize() ,   verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Profil", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))


            profilinhalt(
                vorname = database.einlagerer1.vorname,
                nachname = database.einlagerer1.nachname,
                adress = " ${database.einlagerer1.Strasse}  ${database.einlagerer1.hausnummer}",
                plz =" ${database.einlagerer1.plz}"
            ,
                navController = navController
            )





        }
    }



}


@Composable
fun profilinhalt(navController: NavHostController,vorname:String,nachname:String,adress : String,plz:String ) {
    val einlagerer = database.einlagerer1

    val fahrzeuge = einlagerer.fahrzeuge

    Box( modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxSize()
      ,
        contentAlignment = Alignment.Center)
    {

        Column(modifier =  Modifier.verticalScroll(rememberScrollState()),   verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ) {


Box(modifier = Modifier
    .fillMaxWidth()
    .padding(20.dp)

    .background(MaterialTheme.colors.primaryVariant)){

    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "$nachname,$vorname", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )
        Text(text = "$adress", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )
        Text(text = "$plz", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary) )

    }

}


                Log.d("anan",fahrzeuge.size.toString())
            fahrzeuge.forEach {fahrzeug ->
                fahrzeugCard(navController,fahrzeug.fahrgestellnummer,fahrzeug.grosse,fahrzeug.marke,fahrzeug.kategorie,fahrzeug.besitzer.vorname,fahrzeug.status)
            }
            Spacer(modifier = Modifier.padding(bottom = 30.dp))

            Box(modifier = Modifier.padding(top = 40.dp, bottom = 50.dp)) {
                Button(
                    onClick = {

                        navController.navigate(Screen.Anmeldung.route)

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
                    Text(text = "Abmelden")

                }
            }
            Spacer(modifier = Modifier.padding(bottom = 70.dp))

        }

    }
}


@Composable
fun fahrzeugCard(navController: NavHostController,fahrgestell : Int,grosse:Float,marke : String,kategorie:String,besitzer : String,status: Status){
  val enabled : Boolean
    enabled = status != Status.ungelagert

    Column(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(3.dp, MaterialTheme.colors.secondary, shape = RoundedCornerShape(5.dp))) {

        Image(painter = painterResource(id = R.drawable.garage), contentDescription ="Fahrzeug", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
Box(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text ="Fahrgestellnummer : $fahrgestell  ", modifier = Modifier.padding(20.dp) )
        Text(text ="Größe :  $grosse", modifier = Modifier.padding(20.dp) )
        Text(text ="Marke :  $marke", modifier = Modifier.padding(20.dp) )
        Text(text ="Kategorie :  $kategorie", modifier = Modifier.padding(20.dp) )
        Text(text ="Besitzer :  $besitzer", modifier = Modifier.padding(20.dp) )
        Box() {
            Column(modifier = Modifier.padding(20.dp)
                .background(MaterialTheme.colors.primary)
                .fillMaxSize(),  verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text ="Status :", modifier = Modifier.padding(10.dp) )
                Text(text = "${status.name}", modifier = Modifier.padding(10.dp), fontSize = 20.sp, color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.Bold)
            }
        }



        Spacer(modifier = Modifier.height(20.dp))
        TextButton(onClick = { navController.navigate(Screen.Entgegennahme.passfahrId(fahrgestell)) }, modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary), enabled = enabled) {
            Text(text = "Entgegennahme")
        }
    }

}





    }
}



@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun preee () {
    val navController = rememberNavController()
    Vantage_CommunityTheme() {
        ProfilEinlager(navController = navController)
    }

}

