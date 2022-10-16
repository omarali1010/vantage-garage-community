package com.example.vantage_community.domain.model


/**
 * Eine Klasse für Benutzer Termine
 * @property Termine eine Zuordnung zwischen BenutzerID und Termin
 */
class Kalender {

var Termine:    Map<Int,Termin> = emptyMap<Int,Termin>()


    /**
     * Reservierung eine Termin
     */
    fun terminreservieren(trm:Termin){

    }

    /**
     * anzeige möglcieh Termine für bestimmter Benutzer
     */
    fun anzeigemoglicherTermine(benutzerID :Int){

    }

}