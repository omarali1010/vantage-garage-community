package com.example.vantage_community.domain.model


/**
 * Postfach für Nachrichten zwischen Einlagerer und Lagerhalter
 * @param postfachID  PostfachID
 * @param Nachricht  geschickte Nachricht
 * @param bestätigung  false -> braucht keine bestätigung   : :   true -> braucht bestätigung
 * @property lagerID LagerID
 * @property fahrgestellnummer Fahrzeug fahrgestellnummer
 */
class Nachricht(var postfachID : Int, var Nachricht : String, var  bestätigung : Boolean, var type :Type) {

  var lagerID : Int = 0
  var fahrgestellnummer:Int = 0
}