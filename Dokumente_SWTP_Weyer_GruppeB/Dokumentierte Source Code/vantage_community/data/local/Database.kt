package com.example.vantage_community.data.local

import com.example.vantage_community.domain.model.*

/**
 * eine Instanz der Klasse Database
 */
public val database = Database()

/**
 * Eine Klasse von Database welche die Lokale Daten enthält
 * @constructor initializierung der Databas
 */
class Database {


    constructor(){
        Datenbankinitialisierung()
    }

    /**
     * Objekte von Service
     */
    var service1 : Service = Service(1,30.99,"Einschweißen")
    var service2 : Service = Service(2,34.99,"Glasbox")
    var service3 : Service = Service(3,10.99,"WagenPutzen")
    var service4 : Service = Service(3,103.99,"Klimatisierung")
    var service5 : Service = Service(3,100.99,"Radwechseln")

    var services1 :MutableList<Service> = listOf(service1,service2,service3).toMutableList()
    var services2 :MutableList<Service> = listOf(service1,service2,service3).toMutableList()
    var services3 :MutableList<Service> = listOf(service1,service2,service3).toMutableList()
    var services4 :MutableList<Service> = listOf(service1,service2,service3).toMutableList()
    var services5 :MutableList<Service> = listOf(service1,service2,service3).toMutableList()


    /**
     * Objekte von Lager
     */
    var lager1 : Lager = Lager(1,"08:00 - 22:00",services1,44,"Gießen","Marburgerstraße 14",34234,"Jane Müller")
    var lager2 : Lager = Lager(2,"09:00 - 21:30",services2,110,"Gießen","Frankfurterstraße 10",32434,"Jane Müller")
    var lager3 : Lager = Lager(3,"08:00 - 20:00",services3,150,"Gießen","Eichendorrfring 1",23443,"Jane Müller")
    var lager4 : Lager = Lager(4,"13:00 - 22:00",services4,20,"Gießen","Licherstraße 142",231123,"Jane Müller")
    var lager5 : Lager = Lager(5,"07:00 - 16:30",services5,2,"Gießen","Bahnhofstraße 13",324223,"Jane Müller")


    var lager6 : Lager = Lager(6,"08:00 - 22:00",services5,99,"Hamburg","Frankfurterstraße 10",34234,"Jane Müller")
    var lager7 : Lager = Lager(7,"09:00 - 21:30",services4,15,"Hamburg","Marburgerstraße 14",34234,"Jane Müller")
    var lager8 : Lager = Lager(8,"08:00 - 20:00",services3,130,"Hamburg","Eichendorrfring 1",34234,"Jane Müller")
    var lager9 : Lager = Lager(9,"13:00 - 22:00",services2,30,"Hamburg","Licherstraße 142",34234,"Jane Müller")
    var lager10 : Lager = Lager(10,"07:00 - 16:30",services1,55,"Hamburg","Bahnhofstraße 13",34234,"Jane Müller")


    var lager11 : Lager = Lager(11,"08:00 - 22:00",services4,34,"Frankfurt","Bahnhofstraße 13",34234,"Jane Müller")
    var lager12 : Lager = Lager(12,"09:00 - 21:30",services3,13,"Frankfurt","Frankfurterstraße 10",34234,"Jane Müller")
    var lager13 : Lager = Lager(13,"08:00 - 20:00",services5,234,"Frankfurt","Licherstraße 142",34234,"Jane Müller")
    var lager14 : Lager = Lager(14,"13:00 - 22:00",services1,456,"Frankfurt","Eichendorrfring 1",34234,"Jane Müller")
    var lager15 : Lager = Lager(15,"07:00 - 16:30",services2,664,"Frankfurt","Frankfurterstraße 10",34234,"Jane Müller")


    var lager16 : Lager = Lager(16,"08:00 - 22:00",services2,46,"Berlin","Bahnhofstraße 13",34234,"Jane Müller")
    var lager17 : Lager = Lager(17,"09:00 - 21:30",services1,150,"Berlin","Frankfurterstraße 10",34234,"Jane Müller")
    var lager18 : Lager = Lager(18,"08:00 - 20:00",services4,180,"Berlin","Eichendorrfring 1",34234,"Jane Müller")
    var lager19 : Lager = Lager(19,"13:00 - 22:00",services5,28,"Berlin","Licherstraße 142",34234,"Jane Müller")
    var lager20 : Lager = Lager(20,"07:00 - 16:30",services3,25,"Berlin","Frankfurterstraße 15",34234,"Jane Müller")


    var lager21 : Lager = Lager(16,"08:00 - 22:00",services2,46,"München","Licherstraße 142",34234,"Jane Müller")
    var lager22 : Lager = Lager(17,"09:00 - 21:30",services1,150,"München","Bahnhofstraße 13",34234,"Jane Müller")
    var lager23 : Lager = Lager(18,"08:00 - 20:00",services4,180,"München","Eichendorrfring 1",34234,"Jane Müller")
    var lager24 : Lager = Lager(19,"13:00 - 22:00",services5,28,"München","Frankfurterstraße 10",34234,"Jane Müller")
    var lager25 : Lager = Lager(20,"07:00 - 16:30",services3,25,"München","Frankfurterstraße 15",34234,"Jane Müller")


    /**
     * eine Liste alle Lagers
     */
    var lagers: MutableList<Lager> = listOf<Lager>(lager1,lager3,lager5,lager7,lager9,lager11,lager13,lager15,lager17,lager19,lager21,lager23,lager25,lager2,lager4,lager6,lager8,lager10,lager12,lager14,lager16,lager18,lager20,lager22,lager24).toMutableList()
    //var lagers2: MutableList<Lager> = listOf<Lager>(4).toMutableList()

    /**
     * Objekte von Lagerhalter
     */
    var lagerhalter : Lagerhalter = Lagerhalter("123@gmail.com","123","Wieseckstrasse",32134,23,"Jane","Müller")
    var lagerhalter2 : Lagerhalter = Lagerhalter("456@gmail.com","456","Marburgerstrasse",32342,21,"Justin","Schiffer")

    /**
     * Objekt von Einlagerer
     */
    var einlagerer1: Einlagerer = Einlagerer("789@gmail.com","789","Frankfurterstrasse",32342,1,"Viktor","Mondo")


    /**
     * Objekte von Stellplatz
     */
    var stellplatz1 : Stellplatz = Stellplatz(1,20f, Status.belegt,20.99)
    var stellplatz2 : Stellplatz = Stellplatz(1,40f,Status.frei,20.99)
    var stellplatz3 : Stellplatz = Stellplatz(1,100f,Status.frei,20.99)

    /**
     * Objekte von Buchung
     */
    var buchung1 :Buchung = Buchung(1,1,1,services1,Status.serviceausgewählt)
    var buchung2 :Buchung = Buchung(6,1,2,services1,Status.abgelehnt)

    var fahrzeug1 : Fahrzeug = Fahrzeug(34234,44f,"BMW","LKW",einlagerer1,stellplatz1,Status.ungelagert)
    var fahrzeug2 : Fahrzeug = Fahrzeug(77544,23f,"Audi","Minicar",einlagerer1,stellplatz2,Status.gelagert)

    /**
     * Objekte von Termine
     */
    var termin1 : Termin = Termin("19:00","14.09.2022","Fahrzeug abholen",Status.bestätigt)
    var termin2 : Termin = Termin("7:00","13.05.2022","Fahrzeug Einschweißen",Status.abgelehnt)
    var termin3 : Termin = Termin("22:00","01.09.2022","Fahrzeug im Stellplatz legen",Status.reserviert)


    var termin4 : Termin = Termin("22:00","01.09.2022","frei",Status.frei)
    var termin5  : Termin = Termin("20:00","10.09.2022","frei",Status.frei)
    var termin6 : Termin = Termin("18:30","12.10.2022","frei",Status.frei)
    var termin7 : Termin = Termin("07:00","15.10.2022","frei",Status.frei)
    var termin8  : Termin = Termin("15:00","11.11.2022","frei",Status.frei)

    /**
     * Objekt von postfach
     */
    var postfach : Nachricht = Nachricht(1,"Sie haben ein Termin um 20.12.2022 um 16:00 " , false,Type.Entgegennahme)
    var postfach2 : Nachricht = Nachricht(2,"Sie haben ein Termin um 20.12.2022 um 16:00 um die Auto abzuholen " , true,Type.Termin)


    var postfach3: Nachricht = Nachricht(3,"bestätigen Sie bitte die Fahrzeug abholung " , true, Type.Entgegennahme)
    var postfach4 : Nachricht = Nachricht(4,"Lager Status würde geändert" , true,Type.übermittlung)


    /**
     * Objekt von Systemadmin
     */
    var systemadmin = Systemadmin(1)

    /**
     * Objekt von Kalender
     */
    var kalender = Kalender()

    /**
     * Initializerung der Datenbank
     */
    fun Datenbankinitialisierung(){
        lagerhalter.lagers = lagers
    //    lagerhalter2.lagers = lagers2
        lagerhalter.Termine = listOf( termin4 , termin5 , termin6 , termin7 , termin8 ).toMutableList()
    //   lagerhalter.postfach = listOf(postfach,postfach2).toMutableList()
  //      einlagerer1.postfach = listOf(postfach3,postfach4).toMutableList()


   einlagerer1.fahrzeuge= listOf<Fahrzeug>(fahrzeug1,fahrzeug2).toMutableList()


        kalender.Termine= mapOf(1 to termin1, 1 to termin2 , 2 to termin3)

    }

    /**
     *  eine Funktion um die liste all Lagerhalter zu bekommen
     *  @return Liste alle Lagerhalter
     */
    fun getlagerhalter():List<Lagerhalter>{
        return  listOf(lagerhalter,lagerhalter2)
    }

    /**
     * funktion um alle lager im bestimmter Ort zu bekommen
     * @return liste alle Lager im bestimmte Ort
     *
     */
    fun getLager(Ort: String):List<Lager>{
        val lagers : MutableList<Lager> = emptyList<Lager>().toMutableList()
        lagers.addAll(lagerhalter.lagers)
        lagers.addAll(lagerhalter2.lagers)
        val lagersneeded : MutableList<Lager> = emptyList<Lager>().toMutableList()

        lagers.forEach { lager ->

            if(lager.Ort ==Ort){
                lagersneeded.add(lager)
            }

        }
        return lagersneeded
    }


    /**
     * gibt ein Objekt von Lager mit die LagerID
     * @param ID LagerID
     * @return  Objekt von Lager mit LagerID -> ID
     */
    fun getLagerfromID(ID: Int):Lager{
        val lagers : MutableList<Lager> = emptyList<Lager>().toMutableList()
        lagers.addAll(lagerhalter.lagers)
        //    lagers.addAll(lagerhalter2.lagers)
        val lagersneeded : MutableList<Lager> = emptyList<Lager>().toMutableList()

        lagers.forEach { lager ->

            if(lager.LagerID ==ID){
                return lager
            }


        }

        return  lager1

    }

    /**
     * gibt fahrzeug Objekt von eine fahrgestellnummer
     * @param fahrgestellnummer fahrgestellnummer
     * @return  Objekt von Fahrzeug mit  fahrgestellnummer
     */
    fun getfahrzeug(fahrgestellnummer: Int):Fahrzeug{


        database.einlagerer1.fahrzeuge.forEach { fahrzeug ->

            if(fahrzeug.fahrgestellnummer ==fahrgestellnummer){
                return fahrzeug
            }


        }

        return  database.fahrzeug1

    }

    /**
     * gibt Benutzer Objekt von eine fahrgestellnummer
     * @param fahrgestellnummer fahrgestellnummer
     * @return  Objekt von Benutzer mit  fahrzeug die die fahrgestellnummer hat
     */
    fun getfahrzeugbesitzer(fahrgestellnummer: Int):Benutzer{


        database.einlagerer1.fahrzeuge.forEach { fahrzeug ->

            if(fahrzeug.fahrgestellnummer ==fahrgestellnummer){
                return fahrzeug.besitzer
            }


        }

        return  database.einlagerer1

    }

}

