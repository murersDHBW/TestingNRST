package com.example.helloworld;

public class Person {
    public String Role;
    public boolean CallUpData;

    public Person(String role, boolean callUpData){
        Role = role;
        CallUpData = callUpData;
    }

    public Person() {

    }

    public String getRole() { return Role;}

    public void setRole(String role) {
        Role = role;
    }

    public boolean isCallUpData() {
        return CallUpData;
    }

    public void setCallUpData(boolean callUpData) {
        CallUpData = callUpData;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Role='" + Role + '\'' +
                ", CallUpData=" + CallUpData +
                '}';
    }
}

