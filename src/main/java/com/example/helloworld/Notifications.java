package com.example.helloworld;

public class Notifications {

    private ServerLog _log = null;

    public Notifications(ServerLog log){
        _log = log;
    }

    public void ReactToStatusCode(StatusCode code) {
        if (code == TankStatusCodes.DangerAhead) {
            Alarm();
        } else if (code == TankStatusCodes.CriticalUnderpresssure) {
            PlayAcousticSignal();
            SendNotification(code.StatusMessage, "Betriebsführer");
        } else if (code == TankStatusCodes.CriticalOverpressure) {
            PlayAcousticSignal();
            SendNotification(code.StatusMessage, "Betriebsführer");
            SendNotification(code.StatusMessage, "Wartungsteam");
        } else if (code == TankStatusCodes.Underpressure || code == TankStatusCodes.Overpressure) {
            SendNotification(code.StatusMessage, "Betriebsführer");
            SendNotification(code.StatusMessage, "Wartungsteam");
        }

        // Bei jedem Überschreiten einer Grenze wird etwas geloggt
        if(code != TankStatusCodes.OptimalQuantity){
            _log.WriteInfo(code.StatusMessage);
        }
    }

    public void Alarm() {
        System.out.println("ALARM!!!");
    }

    void PlayAcousticSignal() {
        System.out.println("Es wird ein Ton abgespielt");
    }


    public void SendNotification(String msg, String recipient) {
        System.out.println("Es wird eine Nachricht mit dem Inhalt [" + msg + "] an [" + recipient + "] geschickt");
    }

    public static String GetTankQuantity(double p, String role){

        if(role.equals("OperationsManager")){
            return p + " " + role;
        }
        else if(role.equals("MaintenanceTeam"))
        {
           return p + " " + role;
        }
        else{
            return "Kein Zugriff " + role;
        }

    }

}


