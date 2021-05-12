package com.example.helloworld;

public class Notifications {

    public void ReactToStatusCode(StatusCode code){
        if(code == TankStatusCodes.DangerAhead){
            Alarm();
        } else if(code == TankStatusCodes.CriticalUnderpresssure){
            PlayAcousticSignal();
            SendNotification(code.StatusMessage, "Betriebsführer");
        } else if(code == TankStatusCodes.CriticalOverpressure){
            PlayAcousticSignal();
            SendNotification(code.StatusMessage, "Betriebsführer");
            SendNotification(code.StatusMessage, "Wartungsteam");
        } else if(code == TankStatusCodes.Underpressure || code == TankStatusCodes.Overpressure){
            SendNotification(code.StatusMessage, "Betriebsführer");
            SendNotification(code.StatusMessage, "Wartungsteam");
        }
    }

    private void Alarm(){
        System.out.println("ALARM!!!");
    }

    private void PlayAcousticSignal(){
        System.out.println("Es wird ein Ton abgespielt");
    }

    private void SendNotification(String msg, String recipient){
        System.out.println("Es wird eine Nachricht mit dem Inhalt [" + msg + "] an [" + recipient + "] geschickt");
    }

}


