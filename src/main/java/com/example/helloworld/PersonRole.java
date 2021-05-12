package com.example.helloworld;

import java.util.Random;

public class PersonRole {

    public static Person OperationsManager = new Person("OperationsManager");
    public static Person MaintenanceTeam = new Person("MaintenanceTeam");
    public static Person OtherPerson = new Person("OtherPerson");

    Person[] personlist = new Person[]{OperationsManager, MaintenanceTeam, OtherPerson};

    public String getRandomPerson() {
        Person person = new Person();
        person = personlist[new Random().nextInt(personlist.length)];
        return person.getRole();

    }

}
