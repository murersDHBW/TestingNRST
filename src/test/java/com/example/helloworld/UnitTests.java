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
    @DisplayName("Statuscode prüfen")
    @Description("Überprüft ob der korrekte StatusCode für den Status des Tanks zurückgegeben wird")
    void CheckForCorrectStatusCode() {

        Tank t1 = new Tank();
        StatusCode statusCode = t1.GetStatusForTankQuantity();

        if (statusCode.TankPressure <= 49 && statusCode.TankPressure >= 1) {
            assertEquals(statusCode.ID, TankStatusCodes.CriticalUnderpresssure.ID);
        } else if (statusCode.TankPressure >= 301 && statusCode.TankPressure <= 501) {
            assertEquals(statusCode.ID, TankStatusCodes.CriticalOverpressure.ID);
        } else if (statusCode.TankPressure >= 501) {
            assertEquals(statusCode.ID, TankStatusCodes.DangerAhead.ID);
        } else if (statusCode.TankPressure >= 181 && statusCode.TankPressure <= 219) {
            assertEquals(statusCode.ID, TankStatusCodes.OptimalQuantity.ID);
        } else if (statusCode.TankPressure >= 50 && statusCode.TankPressure <= 180) {
            assertEquals(statusCode.ID, TankStatusCodes.Underpressure.ID);
        } else if (statusCode.TankPressure >= 220) {
            assertEquals(statusCode.ID, TankStatusCodes.Overpressure.ID);
        } else {
            assertEquals(statusCode.ID, TankStatusCodes.StatusError.ID);
        }
    }

    @Test
    @DisplayName("ServerLog Stresstest")
    @Description("Loggt viele Nachrichten an den Server in kurzer Zeit")
    @Timeout(5)
        // Sekunden
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
        Tank t1 = new Tank();
        StatusCode statusCode = t1.GetStatusForTankQuantity();

        String testServer = "dies.ist.die.adresse.zum.testserver";
        int testPort = 8080;
        ServerLog log = new ServerLog(testServer, testPort);

        Notifications notifications = new Notifications(log);
        int logCount = log.LogCount;
        notifications.ReactToStatusCode(statusCode);

        if (statusCode != TankStatusCodes.OptimalQuantity) {
            assertTrue(logCount != log.LogCount);
        }
    }

    @Test
    @DisplayName("Prüfe Tank Antwortzeit")
    @Description("Es wird 30 Minuten lang getestet, ob die Antwortzeit des Tanks stetig unter 10ms liegt.")
    void EnsureTankStatusMessageBelow10ms() {
        Tank testTank = new Tank();

        long testDuration = TimeUnit.NANOSECONDS.convert(30L, TimeUnit.MINUTES);
        long endTime = System.nanoTime() + testDuration;

        while (System.nanoTime() < endTime) {
            Instant starts = Instant.now();
            testTank.GetStatusForTankQuantity();
            Instant ends = Instant.now();

            // 10_000_000 Nanosekunden sind 10 Millisekunden
            // Die Duration muss kleiner als dieser Wert sein, damit der Test nicht fehlschlägt
            assertTrue(Duration.between(starts, ends).getNano() < 10_000_000);
        }
    }
}