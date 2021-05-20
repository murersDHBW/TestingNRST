package KawumAG;

public class Tank {

    private IReadPressure pressureSensor;

    public Tank(IReadPressure sensor){
        pressureSensor = sensor;
    }

    public double getPressure(){
        return pressureSensor.readPressure();
    }

    public StatusCode getStatus(){
        double p = getPressure();

        if (p <= 49 && p >= 0){
            StatusCode code = TankStatusCodes.CriticalUnderpresssure;
            code.TankPressure = p;
            return code;
        }
        else if (p >= 301 && p <= 500){
            StatusCode code = TankStatusCodes.CriticalOverpressure;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 501){
            StatusCode code = TankStatusCodes.DangerAhead;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 181 && p<= 219){
            StatusCode code = TankStatusCodes.OptimalPressure;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 50 && p<= 180){
            StatusCode code = TankStatusCodes.Underpressure;
            code.TankPressure = p;
            return code;
        }
        else if(p >= 220){
            StatusCode code = TankStatusCodes.Overpressure;
            code.TankPressure = p;
            return code;
        }

        // Kein Status
        return TankStatusCodes.StatusError;
    }
}
