package com.example.vantage_community.domain.model

import java.util.*


/**
 * Eine Klasse für Fehlermeldung
 * @property AnfrageID AnfrageID
 * @property einlagererID EinlagererID
 * @property timestamp Zeit der Fehler
 * @property fehlercode Fehlercode
 */
class Fehlermeldung {

    var AnfrageID : Int = 0
    var einlagererID : Int = 0
    var timestamp : Date = Date()
    var fehlercode :String = ""


    /**
     * Senden den Fehler an den Einlagerer
     *
     * @param suchanfrage Suchanfrage
     *
     */
    fun schickefehlermeldung(suchanfrage: Suchanfrage){

    }

    /**
     *
     * Senden den Fehler an den Admin
     */
    fun leiterfehlermeldunganadmin(){

    }
}