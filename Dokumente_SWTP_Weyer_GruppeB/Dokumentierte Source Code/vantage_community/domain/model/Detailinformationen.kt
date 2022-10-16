package com.example.vantage_community.domain.model

/**
 *
 * Diese Klasse enthält die Detailinformationen für ein bestimmtes Lager, wenn der Lagerhalter es freigeschaltet hat.
 *
 * @property detailsinformationenID DetailinformationID
 * @property lagerID  LagerID
 *
 *
 */
class Detailinformationen {

    var detailsinformationenID : Int = 0
    var lagerID : Int = 0


    /**
     *
     * sendet die Detailinformationen für den Einlagerer, da der Lagerhalter sie freigeschaltet hat
     * @return  die Detailsinformationen
     */
    fun zugriffdetailsinformationen() : String{
 return  ""
    }
}