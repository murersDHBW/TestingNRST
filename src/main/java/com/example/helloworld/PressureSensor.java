package com.example.helloworld;

public class PressureSensor implements IReadPressure {

    @Override
    public double readPressure() {

        // Der wirkliche Sensor würde hier einen Sensor auslesen, und diesen Wert zurückgeben
        return Util.GenerateRandomNumber(0, 600);
    }
}
