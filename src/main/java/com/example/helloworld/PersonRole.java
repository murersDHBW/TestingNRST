package com.example.helloworld;

import java.util.Random;

public class PersonRole {

    public static Person OperationsManager = new Person("OperationsManager", true);
    public static Person MaintenanceTeam = new Person("MaintenanceTeam", true);
    public static Person OtherPerson = new Person("OtherPerson", false);

    Person[] personlist = new Person[]{OperationsManager, MaintenanceTeam, OtherPerson};

    public String getRandomPerson() {
        Person person = new Person();
        person = personlist[new Random().nextInt(personlist.length)];
        return person.getRole();

    }

}
