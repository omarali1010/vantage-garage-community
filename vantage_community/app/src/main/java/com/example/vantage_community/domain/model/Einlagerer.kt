package com.example.vantage_community.domain.model

import com.example.vantage_community.data.local.database

/**
 * Diese Klasse ist für den Einlagerer, der die Klasse Benutzer erweitert
 *
 * @constructor Die Parameter der Benutzerklasse werden an den Konstruktor übergeben
 * @property postfach eine Liste aller Nachrichten, die im Postfach angezeigt werden
 * @property buchung eine Liste aller Buchungen
 * @property sua ein Objekt der Klasse Suchanfrage
 * @property dias eine Liste aller Detailsinformationsanfrage
 *  @property fahrzeuge eine Liste aller Fahrzeuge
 *
 */
class Einlagerer(email:String,pass:String,strasse:String,plz:Int,haus:Int,vor:String,nach:String): Benutzer(emailAdress = email, password = pass,plz=plz,hausnummer=haus,vorname=vor,nachname=nach,
    Strasse = strasse
) {

    var postfach : MutableList<Nachricht> = emptyList<Nachricht>().toMutableList()
    var buchung : MutableList<Buchung> = emptyList<Buchung>().toMutableList()
    var sua :Suchanfrage = Suchanfrage()
    var dias : MutableList<Detailinformationsanfrage> = emptyList<Detailinformationsanfrage>().toMutableList()
    var fahrzeuge : MutableList<Fahrzeug> =emptyList<Fahrzeug>().toMutableList()

    /**
     * Suche nach den verfügbaren Lagern in einem bestimmten Ort
     * @param Ort Ort der Suche
     */
    fun suchelager(Ort : String) : List<Lager>{
       return database.getLager(Ort)
    }

    /**
     * Eine Anfrage des Einlagerers zum Abruf der verfügbaren Services
     */
    fun anfrageangebotenenservices(lagerID: Int) :List<Service>{

     val    lager : Lager = database.getLagerfromID(lagerID)
       return  lager.angeboteneServices
    }

    /**
     * Auswahl bestimmter services aus der Liste der verfügbaren services
     *
     * @param services Die ausgewählte Services
     * @param lagerID LagerID
     * @param einlagererID EinlagererID
     */
   fun  servicesauswaelen(services : MutableList<Service>,
    lagerID:Int,einlagererID:Int){


   }

    /**
     * Erstellen eines Objekts der Suchanfrage
     * @param einlagererID EinlagererID
     */
    fun erstellesuchanfrage(einlagererID: Int){

    }

    /**
     * der Einlagerer will mehr Informationen hinzufügen, um die Suche weiter zu filtern
     * @param suchanfrageID SuchanfrageID
     * @param infos Eine Liste von Informationen zum Filtern der Suche
     */
    fun ergaenzesuchanfrage(suchanfrageID: Int,infos:List<String>){

    }

    /**
     * wenn der Lagerhalter beschlossen hat, einige der Dienstleistungen zu
     * akzeptieren und nicht alle,
     * benutzt man diese Funktion,um das reduzierte Servoces angebot zu akzeptieren
     * @return true für akzeptiert und false für abgelehnt
     */
    fun BestätigungdesreduziertenAngebots() : Boolean{

        return false
    }


}