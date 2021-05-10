package com.example.helloworld;

import java.util.Random;

class Main {
    public static void main (String[] args) {



        System.out.print(randomNumber());
    }

    public static double randomNumber(){
        double min = 1;
        double max = 600;

        double randomFloatNumber = min + Math.random() * (max - min);
        return randomFloatNumber;

//        return (int)Math.floor(Math.random()*(max-min+1)+min);


    }

    public static void reactions(){
        double p = randomNumber();
        if (p < 50 && p >= 0){
            System.out.println("Akustisches Signal und Benachrichtigung an Betriebsführer");
        }
        else if (p >= 301 && p <= 501){
            // do sth
        }

    }


}
