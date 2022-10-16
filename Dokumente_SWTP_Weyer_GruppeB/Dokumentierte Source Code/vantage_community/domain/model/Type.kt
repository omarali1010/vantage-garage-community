package com.example.vantage_community.domain.model

/**
 * Ein Enum Class für Types von Nachrichten ,die bei Postfach benutzt wird
 */
enum class Type {
    error,
    Termin,
    Entgegennahme,
    Entgegennahmeanfrage,
    übermittlung,
    Entgegennahmebestätigunganfrage,
    EntgegennahmeAblehnunuganfrage,
    bestätigt,
    abgelehnt,
    detailsinformationanfrage,
    detailsinformationantwort,
    buchungübermittelt,
    buchungbestätigen,
    buchungablehnung
}