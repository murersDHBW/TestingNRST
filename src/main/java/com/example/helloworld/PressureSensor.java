package com.example.helloworld;

public class PressureSensor implements IReadPressure {

    @Override
    public double readPressure() {
        return Util.GenerateRandomNumber(0, 600);
    }
}
