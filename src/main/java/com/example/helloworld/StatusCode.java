package com.example.helloworld;

import java.util.Objects;

public class StatusCode {

    public StatusCode(int id, String errorMessage){
        ID = id;
        StatusMessage = errorMessage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getErrorMessage() {
        return StatusMessage;
    }

    public void setErrorMessage(String errorMessage) {
        StatusMessage = errorMessage;
    }

    public int ID;

    public String StatusMessage;

    public double getTankPressure() {
        return TankPressure;
    }

    public void setTankPressure(double pressure){
        TankPressure = pressure;
    }

    public double TankPressure;

    @Override
    public String toString() {
        return "StatusCode{" +
                "ID=" + ID +
                ", ErrorMessage='" + StatusMessage + '\'' +
                ", TankPressure=" + TankPressure +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusCode that = (StatusCode) o;
        return ID == that.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
