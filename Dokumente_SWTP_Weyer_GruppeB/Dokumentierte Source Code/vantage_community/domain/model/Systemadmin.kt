package com.example.vantage_community.domain.model


/**
 * eine Klasse für das Systemadmin
 * @param SystemadminID SystemadminID
 * @property fehlermeldung eine Liste von Fehlermeldungen
 */
class Systemadmin(SystemadminID : Int) {


var fehlermeldung : MutableList<Fehlermeldung> = emptyList<Fehlermeldung>().toMutableList()



}