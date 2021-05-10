package com.example.helloworld;

public class Main {
    public static void main (String[] args) {



        System.out.print(randomNumber());
    }

    public static int randomNumber(){
        float min = 1;
        float max = 600;

        return (int)Math.floor(Math.random()*(max-min+1)+min);


    }

    public static void reactions(){
        int p = randomNumber();
        if (p < 50 && p >= 0){
            System.out.println("Akustisches Signal und Benachrichtigung an Betriebsführer");
        }
        else if (p >= 301 && p <= 501)

    }


}
