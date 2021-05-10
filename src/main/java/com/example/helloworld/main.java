package com.example.helloworld;

import java.util.Random;

class Main {
    public static void main (String[] args) {



        System.out.print(reactions());
    }

    public static double randomNumber(){
        double min = 1;
        double max = 600;

        double randomFloatNumber = min + Math.random() * (max - min);
        randomFloatNumber = (Math.round(randomFloatNumber * 100.0)/ 100.0);
        return randomFloatNumber;

//        return (int)Math.floor(Math.random()*(max-min+1)+min);


    }

    public static String reactions(){

        double p = randomNumber();
        String answer = "";


        if (p <= 49 && p >= 1){
            answer = "Füllstand:" + p + ".Akustisches Signal und Benachrichtigung an Betriebsführer";
        }
        else if (p >= 301 && p <= 501){
            answer = "Füllstand:" + p + ".Akustisches Signal, Benachrichtigung an Betriebsführer und Information an Wartungsteam";
        }
        else if(p >= 501){
            answer = "Füllstand:" + p + ".Alarm auslösen und Evakuierung des Gebäudes";
        }
        else if(p >= 181 && p<= 219){
            answer = "Füllstand:" + p + ". Der Stand ist in einem Soliden gediegenen Bereich";
        }
        else if(p >= 50 && p<= 180 || p >= 220 && p<= 300){
            answer = "Füllstand:" + p + ". Benachrichtigung an Betriebsführer und Information an Wartungsteam";
        }

        return answer;

    }


}
