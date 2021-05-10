package com.example.helloworld;

import java.util.Random;

public class Tank {

    public static double randomNumber() {
        double min = 1;
        double max = 600;

        double randomFloatNumber = min + Math.random() * (max - min);
        randomFloatNumber = (Math.round(randomFloatNumber * 100.0) / 100.0);
        return randomFloatNumber;
    }

    public double getQuantity(){
        return randomNumber();
    }
}
