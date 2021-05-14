package com.example.helloworld;

class Main {
    public static void main (String[] args) {


        Tank t1 = new Tank();
        double tankQuantity = t1.getPressure();
        PersonRole personrole = new PersonRole();
        System.out.print(
                Notifications.GetTankQuantity(tankQuantity, personrole.getRandomPerson()));
    }
}
