package com.example.vantage_community.domain.model


/**
 * Eine Klasse für Termine
 * @param Zeit Zeit
 * @param Datum Datum
 * @param Termingrund Grund der Termin
 * @param status Status der Termin
 */
class Termin(var Zeit : String ,var Datum : String ,var Termingrund :String,var status: Status ) {


    /**
     * bestätigung der Termin übermitteln
     */
    fun ubermittlungdesbestaetigentermins(){

    }


    /**
     * Termin übermitteln
     */
    fun terminubermittlung(){

    }
}