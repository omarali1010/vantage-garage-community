package com.example.vantage_community.domain.model

/**
 * Diese Klasse ist für die Detailinformationsanfrage, die vom Einlagerer an den Lagerhalter gesendet wird
 * @property detailanfrageID DetailanfrageID
 * @property einlagererID einlagererID
 * @property lagerhalterID lagerhalterID
 * @property fragen Optionale Fragen, die der Anfrage hinzugefügt werden können
 * @property bestaetigt Der Stand der Anfrage
 */
class Detailinformationsanfrage {

    var detailanfrageID : Int = 0
    var einlagererID :Int = 1
    var lagerhalterID : Int = 1
    var fragen :String = ""
    var bestaetigt : Boolean = false


    /**
     * schickt die Anfrage an den Lagerhalter
     * @param fragen Optionale Fragen, die der Anfrage hinzugefügt werden können
     */
    fun anfrageweiterleiten(fragen : String =""){

    }

    /**
     * Den Status der Anfrage vom Lagerhalter ändern
     * @param bestaetigt Der Stand der Anfrage
     */
    fun zugriffdetailsinformationen(bestaetigt : Boolean){

    }

    /**
     * Die Detailinformationen des Lagerhalters werden an den Einlagerer gesendet
     * @param detailinformationen Detailinformationen
     */
    fun ubermittledetailsinformationen(detailinformationen: Detailinformationen){

    }
    /**
     * Der Angebot des Lagerhalters werden an den Einlagerer gesendet
     * @param preis Angebotpreis
     */
    fun ubermittleangebot(preis : Int){

    }

    /**
     * wenn bei der Anfrage etwas schief gelaufen ist
     */
   fun  erzeugeFehlermeldung(){

    }

}