package com.example.vantage_community.domain.model

/**
 *  eine Klasse für stellplatz
 *  @param lagerID LagerID
 *  @param grosse Größe
 *  @param status (belegt , unbelegt)
 *  @param tageskosten Tageskosten
 *  @property stellplatzID StellplatzID
 */
class Stellplatz(val lagerID: Int, val grosse :Float, var status:Status, var tageskosten:Double) {

    private val  stellplatzID : Int = 0
}