package com.example.vantage_community.domain.model

/**
 * Eine Klasse für Lager
 *
 * @param LagerID LagerID
 * @param serivezeiten Service Zeiten
 * @param angeboteneServices Angebotene Services
 * @param Anzahlstellplaetze Anzahl Verfügbare Stellplätze
 * @param Ort Ort
 * @param adress Adress
 * @param plz PLZ
 * @param besitzer Besitzer
 */
class Lager(val LagerID:Int,var serivezeiten : String ,var angeboteneServices : MutableList<Service>,var Anzahlstellplaetze:Int ,var Ort : String,var adress :String ,var plz:Int ,var besitzer : String) {


    /**
     * azeigt die angebotene Services
     * @return Liste von Angebotene Services
     */
    fun anzeigeAngeboteneServices():MutableList<Service>{
        return  angeboteneServices
    }
}