package com.example.helloworld;

public class Main {
    public static void main (String[] args) {

        System.out.print(randomNumber());
    }

    public static int randomNumber(){
        int min = 1;
        int max = 600;

        return (int)Math.floor(Math.random()*(max-min+1)+min);

        
    }

}
