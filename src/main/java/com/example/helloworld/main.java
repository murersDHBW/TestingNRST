package com.example.helloworld;

class Main {
    public static void main (String[] args) {

        Tank t1 = new Tank();
        System.out.print(Notifications.GetStatusForTankQuantity(t1.getQuantity()));
    }
}
