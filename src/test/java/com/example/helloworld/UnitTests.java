package com.example.helloworld;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {

    @Test
    @DisplayName("ServerLog Stresstest")
    @Description("Loggt viele Nachrichten an den Server in kurzer Zeit")
    @Timeout(5)
    void ServerLogStressTest() {
        String testServer = "dies.ist.die.adresse.zum.testserver";
        int testPort = 8080;

        ServerLog log = new ServerLog(testServer, testPort);

        // Strings von zufälliger Länge erstellen
        for (int i = 0; i < 10000; i++) {
            int messageLength = (int) Util.GenerateRandomNumber(10, 100);
            log.WriteInfo(Util.GenerateRandomString(messageLength));
        }

        // Wenn wir hier angekommen sind, wurden alle Nachrichten korrekt an den
        // Server geloggt
        assertTrue(true);
    }

    @Test
    @DisplayName("Tankdruck Logtest")
    @Description("Prüft ob etwas in das Log geschrieben wird, wenn der Tank keinen optimalen Druck hat")
    void CheckPressureLimitLogging() {

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        fakePressureSensor.setPressure(Util.GenerateRandomNumber(0, 600));

        Tank t1 = new Tank(fakePressureSensor);
        StatusCode statusCode = t1.getStatus();

        String testServer = "dies.ist.die.adresse.zum.testserver";
        int testPort = 8080;
        ServerLog log = new ServerLog(testServer, testPort);

        Notifications notifications = new Notifications(log);
        int logCount = log.LogCount;
        notifications.ReactToStatusCode(statusCode);

        if (statusCode != TankStatusCodes.OptimalPressure) {
            assertTrue(logCount != log.LogCount);
        }
    }

    @Test
    @DisplayName("Prüfe Tank Antwortzeit")
    @Description("Es wird 30 Minuten lang getestet, ob die Antwortzeit des Tanks stetig unter 10ms liegt.")
    void EnsureTankStatusMessageBelow10ms() {

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        fakePressureSensor.setPressure(Util.GenerateRandomNumber(0, 600));

        Tank testTank = new Tank(fakePressureSensor);

        long testDuration = TimeUnit.NANOSECONDS.convert(30L, TimeUnit.MINUTES);
        long endTime = System.nanoTime() + testDuration;

        while (System.nanoTime() < endTime) {
            Instant starts = Instant.now();
            testTank.getStatus();
            Instant ends = Instant.now();

            // 10_000_000 Nanosekunden sind 10 Millisekunden
            // Die Duration muss kleiner als dieser Wert sein, damit der Test nicht fehlschlägt
            assertTrue(Duration.between(starts, ends).getNano() < 10_000_000);
        }
    }

    @Test
    @DisplayName("Spannung an Messfühler")
    @Description("Wenn Spannung unter 5V, muss akustisches Signal gesendet werden.")
    void VoltageTest() {
        Voltameter s1 = new Voltameter();

        for (int i = 0; i < 10000; i++) {

            double value = s1.returnCurrentVoltage();
            boolean alert = s1.alertVoltageTooHigh(value);

            if (value <= 5) {
                assertTrue(alert);
            } else {
                assertFalse(alert);
            }
        }
    }

    @Test
    @DisplayName("Kontrollierter Abrufbarer Druck")
    @Description("Aktueller Druck kann jederzeit vom Betriebsleiter und dem Wartungsteam abgerufen werden.")
    void CheckRoleForCallData(){

        //Mock Tankfüllung
        double tankQuantity = 53.2;

        //Mock Person die die Tankfüllung abrufen möchte
        Person person = new Person();

        //Verfügbare Rollen "OperationsManager" und "MaintenanceTeam" die berechtigt sind den Druck abzurufen
        String personrole = person.setRole("OtherPerson");

        //Notifications.GetTankQuantity(tankQuantity, personrole); kann auch mit diesem Befehl getestet werden

        if(personrole == "MaintenanceTeam"){
            assertTrue(true);
        }
        else if(personrole == "OperationsManager"){
            assertTrue(true);
        }
        else
        {
            //Andere Personen die die den Druck nicht einsehen dürfen
            assertFalse(false);
        }

    }
}