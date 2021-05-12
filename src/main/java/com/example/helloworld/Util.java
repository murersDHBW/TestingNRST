package com.example.helloworld;

import java.util.Random;

public final class Util {

    // Private constructor damit Util nicht instanziert wird
    private Util() {
        throw new IllegalStateException("Util class");
    }

    public static double GenerateRandomNumber(double min, double max) {
        double randomFloatNumber = min + Math.random() * (max - min);
        randomFloatNumber = (Math.round(randomFloatNumber * 100.0) / 100.0);
        return randomFloatNumber;
    }

    public static String GenerateRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
