package com.example.vantage_community.navigation


/**
 * Eine klasse die eine Liste alle Bildschirme hat
 */
sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Anmeldung : Screen("Anmeldung_screen")
    object Registrierung : Screen("Registrierung_screen")
    object  Profil : Screen("Profil")
    object  Postfach : Screen("Postfach")
    object  ProfilLagerhalter : Screen("ProfilLagerhalter")
    object  PostfachLagerhalter : Screen("PostfachLagerhalter")
    object  LagerLagerhalter : Screen("LagerLagerhalter")
    object  BottomnavEinlagerer : Screen("BottomnavEinlagerer")
    object BottomnavLagerhalter :Screen("BottommavLagerhalter")
    object  Neuelager : Screen("Neuelager")
    object Stellplatzsuche : Screen("Stellplatzsuche")
    //object Entgegennahme : Screen("Entgegennahme")

    object Detailsinfo : Screen("Detailsinfo/{lager}") {
        fun passLagerId(Lagerid: Int): String {
            return "Detailsinfo/$Lagerid"
        }
    }
    object lagerandern : Screen("lagerandern/{lager}") {
        fun passLagerId(Lagerid: Int): String {
            return "lagerandern/$Lagerid"
        }
    }

    object Servicebuchen : Screen("servicebuchen/{lager}") {
        fun passLagerId(Lagerid: Int): String {
            return "servicebuchen/$Lagerid"
        }
    }

    object Entgegennahme : Screen("Entgegennahme/{fahrzeugid}") {
        fun passfahrId(fahrzeugid: Int): String {
            return "Entgegennahme/$fahrzeugid"
        }
    }

}