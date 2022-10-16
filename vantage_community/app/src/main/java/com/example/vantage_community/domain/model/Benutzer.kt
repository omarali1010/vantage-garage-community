package com.example.vantage_community.domain.model


/**
 * Diese Klasse ist eine allgemeine Klasse für die Benutzer, die ihre persönlichen Daten enthalten
 * @param emailAdress Email Adresse
 * @param password   Passwort
 * @param Strasse  Straße
 * @param plz    Postleitzahl
 * @param hausnummer hausnummer
 * @param vorname  Vorname
 * @param nachname Nachname
 * @property benutzerID  BenutzerID
 *
 *
 */
open class Benutzer(val emailAdress : String,var password : String,var Strasse : String,var plz : Int,var hausnummer : Int ,var vorname : String,var nachname:String) {

    val benutzerID : Int = 0

}