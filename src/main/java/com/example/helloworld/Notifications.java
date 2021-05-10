package com.example.helloworld;

public class Notifications {

    public static StatusCode GetStatusForTankQuantity(double p){

        if (p <= 49 && p >= 1){
            StatusCode code = StatusCodes.CriticalUnderpresssure;
            code.TankPressure = p;
            return code;
        }
        else if (p >= 301 && p <= 501){
            StatusCode code = StatusCodes.CriticalOverpressure;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 501){
            StatusCode code = StatusCodes.DangerAhead;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 181 && p<= 219){
            StatusCode code = StatusCodes.OptimalQuantity;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 50 && p<= 180){
            StatusCode code = StatusCodes.Underpressure;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 220){
            StatusCode code = StatusCodes.Overpressure;
            code.TankPressure = p;
            return code;
        }

        // Kein Status
        return StatusCodes.StatusError;
    }
}


