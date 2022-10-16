package com.example.vantage_community.domain.model



/**
 * Diese Klasse ist für den Lagerhalter, der die Klasse Benutzer erweitert
 *
 * @constructor Die Parameter der Benutzerklasse werden an den Konstruktor übergeben
 * @property postfach eine Liste aller Nachrichten, die im Postfach angezeigt werden
 * @property lagers eine Liste von Lagers
 * @property Termine eine Liste von Verfügbare Termine
 *
 */
class Lagerhalter (email:String,pass:String,strasse:String,plz:Int,haus:Int,vor:String,nach:String) : Benutzer(emailAdress = email, password = pass,plz=plz,hausnummer=haus,vorname=vor,nachname=nach,
    Strasse = strasse
){

    var postfach : MutableList<Nachricht> = emptyList<Nachricht>().toMutableList()
    var lagers : MutableList<Lager> = emptyList<Lager>().toMutableList()
    var Termine : MutableList<Termin> = emptyList<Termin>().toMutableList()


    /**
     * Buchung bestätigung
     * @param buchung Buchung Object
     */
    fun servicebuchungbestaetigen(buchung: Buchung){

    }

    /**
     * Buchung Teil bestätigen (nur einige Services wurde akzeptiert)
     * @param buchung Buchung
     * @param services eine Liste von akzeptiert Services
     */
    fun serviceteilbestaetigen(buchung: Buchung,services:MutableList<Service>){

    }

    /**
     * Buchung Ablehnen
     * @param buchung Buchung
     *
     */
    fun  AblehnungdesServiceangebots(buchung:Buchung){

    }



}