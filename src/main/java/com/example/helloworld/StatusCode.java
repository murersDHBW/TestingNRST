package com.example.helloworld;

public class StatusCode {

    public StatusCode(int id, String errorMessage){
        ID = id;
        ErrorMessage = errorMessage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public int ID;

    public String ErrorMessage;

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
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", TankPressure=" + TankPressure +
                '}';
    }
}
