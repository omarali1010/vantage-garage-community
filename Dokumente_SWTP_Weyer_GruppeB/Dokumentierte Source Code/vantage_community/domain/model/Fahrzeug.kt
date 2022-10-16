package com.example.vantage_community.domain.model

/**
 * Eine Klasse für Fahrzeuge
 * @param fahrgestellnummer Fahrgestellnummer
 * @param grosse Größe
 * @param marke Marke
 * @param kategorie Kategorie
 * @param besitzer Besitzer
 * @param stellplatz Stellplatz
 * @param status Status (gelagert , ungelagert)
 */
class Fahrzeug(val fahrgestellnummer:Int,val grosse : Float,val marke : String ,val kategorie : String,var besitzer : Einlagerer,var stellplatz: Stellplatz,var status: Status) {


    /**
     * eine Funktion, die das Objekt des Fahrzeugs ermittelt
     * @return Fahrzeug Object
     */
    fun fahrzeuginformationangeben() : Fahrzeug{
        return this
    }
}