package com.example.vantage_community.presentation.screens.lagerhalter.profil

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.vantage_community.data.local.Database
import com.example.vantage_community.data.local.database
import com.example.vantage_community.navigation.Screen
import com.example.vantage_community.presentation.screens.lagerhalter.bottomnav.bottomnavLagerhalter
import com.example.vantage_community.ui.theme.Vantage_CommunityTheme

/**
 * Profil der Lagerhalter Bildschirm
 */
@Composable
fun ProfilLagerhalter(
    navController: NavHostController


){


    Scaffold(
        bottomBar = { bottomnavLagerhalter(navController = navController) }
    ) {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            profilinhalt(vorname = database.lagerhalter.vorname, nachname = database.lagerhalter.nachname, plz = "${database.lagerhalter.plz}", adress ="${database.lagerhalter.Strasse}  ${database.lagerhalter.hausnummer}", MonKost = 200, MonVer = 1000,database.lagerhalter.lagers.size )
            Spacer(modifier = Modifier.padding(50.dp))

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

        }

    }


}


@Composable
fun profilinhalt(vorname:String,nachname:String,plz:String,adress : String , MonKost : Int, MonVer : Int,lagers : Int) {
    Box( modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxWidth()
        ,
        contentAlignment = Alignment.Center)
    {



        Column(modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize() ,   verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Profil", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive, color = MaterialTheme.colors.onPrimary))

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

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp).border(2.dp,MaterialTheme.colors.secondary, RoundedCornerShape(2.dp))

                .background(MaterialTheme.colors.primaryVariant)){

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Anzahl Lager : $lagers ", style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Default, color = MaterialTheme.colors.onPrimary), modifier = Modifier.padding(top = 10.dp) )

                }

            }
        }




    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun sdf() {
    val navController = rememberNavController()
    Vantage_CommunityTheme() {
        ProfilLagerhalter(navController)

    }

}