package com.example.helloworld;

public class TankStatusCodes {

    public static StatusCode CriticalUnderpresssure = new StatusCode(1, "Akustisches Signal und Benachrichtigung an Betriebsführer");

    public static StatusCode CriticalOverpressure = new StatusCode(2, "Akustisches Signal, Benachrichtigung an Betriebsführer und Information an Wartungsteam");

    public static StatusCode DangerAhead = new StatusCode(3, "Alarm auslösen und Evakuierung des Gebäudes");

    public static StatusCode OptimalQuantity = new StatusCode(4, "Der Stand ist in einem Soliden gediegenen Bereich");

    public static StatusCode Underpressure = new StatusCode(5, "Benachrichtigung an Betriebsführer und Information an Wartungsteam");

    public static StatusCode Overpressure = new StatusCode(6, "Benachrichtigung an Betriebsführer und Information an Wartungsteam");

    public static StatusCode StatusError = new StatusCode(-1, "Status konnte nicht ermittelt werden");

}
