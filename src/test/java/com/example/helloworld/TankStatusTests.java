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
            assertSame(tank.getStatus(), TankStatusCodes.CriticalUnderpresssure);
        }
    }

    @Test
    @DisplayName("Kritischen Überdruck prüfen")
    void CheckCriticalOverpressure(){

        FakePressureSensor fakePressureSensor = new FakePressureSensor();
        Tank tank = new Tank(fakePressureSensor);

        double[] values = {301, 500, 1000};

        for (double value : values){
            fakePressureSensor.setPressure(value);
            assertSame(tank.getStatus(), TankStatusCodes.CriticalOverpressure);
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
            assertSame(tank.getStatus(), TankStatusCodes.OptimalPressure);
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
            assertSame(tank.getStatus(), TankStatusCodes.Underpressure);
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
            assertSame(tank.getStatus(), TankStatusCodes.Overpressure);
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
            assertSame(tank.getStatus(), TankStatusCodes.DangerAhead);
        }
    }
}
