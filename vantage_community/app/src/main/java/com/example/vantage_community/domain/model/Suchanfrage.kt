package com.example.vantage_community.domain.model


/**
 * eine Klasse für Suchanfragen
 * @property AnfrageID AnfrageID
 * @property informationen eine Liste von Detailsinformationen
 * @property einlagererID EinlagererID
 * @property ergLager ergebnis Lager
 * @property erganzahl ergebnis Anzahl
 */
class Suchanfrage {

   var  AnfrageID : Int = 0
    var informationen : MutableList<Detailinformationen> = emptyList<Detailinformationen>().toMutableList()
    var einlagererID : Int = 0
    var erganzahl :Int =0
    var ergLager : MutableList<Lager> = emptyList<Lager>().toMutableList()


 /**
  * Resultat schicken
  */
    fun schickeResultat(){

    }

 /**
  * Fehlermeldung erzeigen ,falls was schief läuft
  */
    fun erzeugeFehlermeldung(){

    }

 /**
  * leer Felder der Suchanfrage ersetzen
  */
    fun ersetzeLeereFelder(){

    }

}