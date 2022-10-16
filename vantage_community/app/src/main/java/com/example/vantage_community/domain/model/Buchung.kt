package com.example.vantage_community.domain.model


/**
 * Diese Klasse ist für die Serive Buchung zwischen dem Einlagerer und lagerhalter (Service Verwalten)
 *
 * @param lagerID LagerID
 * @param einlagererID EinlagererID
 * @param lagerhalterID LagerhalterID
 * @param services  Liste der ausgewählten services
 * @param status Zustand der Buchung
 */
class Buchung(lagerID:Int,einlagererID: Int,lagerhalterID: Int,services: MutableList<Service>,status: Status) {



}