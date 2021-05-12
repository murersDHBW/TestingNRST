package com.example.helloworld;

public class SpannungsMesser {

    public SpannungsMesser() {

    }

    public double returnCurrentVoltage() {
        return Util.GenerateRandomNumber(0.1, 10.0);
    }

    public boolean alertVoltageTooHigh(double val) {
        return val <= 5.0;
    }

}
