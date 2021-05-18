package com.example.helloworld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

class TankStatusTests {

    @Test
    @DisplayName("Kritischen Unterdruck prüfen")
    void CheckCriticalUnderpressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {0, 20, 49};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.CriticalUnderpresssure, tank.getStatus());
        }
    }

    @Test
    @DisplayName("Kritischen Überdruck prüfen")
    void CheckCriticalOverpressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {301, 500};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.CriticalOverpressure, tank.getStatus());
        }
    }

    @Test
    @DisplayName("Optimalen Druck prüfen")
    void CheckOptimalPressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {181, 200, 219};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.OptimalPressure, tank.getStatus());
        }
    }


    @Test
    @DisplayName("Unterdruck prüfen")
    void CheckUnderpressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {50, 100, 180};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.Underpressure, tank.getStatus());
        }
    }

    @Test
    @DisplayName("Überdruck prüfen")
    void CheckOverpressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {220, 250, 300};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.Overpressure, tank.getStatus());
        }
    }

    @Test
    @DisplayName("Gefährlichen Druck prüfen")
    void CheckDangerousPressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {501, 1000};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.DangerAhead, tank.getStatus());
        }
    }

    @Test
    @DisplayName("Ungültige Druckwerte prüfen")
    void CheckInvalidPressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {-10, -500};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(TankStatusCodes.StatusError, tank.getStatus());
        }
    }
}
