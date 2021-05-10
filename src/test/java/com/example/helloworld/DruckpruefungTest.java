package com.example.helloworld;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DruckpruefungTest {

    @Test
    @DisplayName("Statuscode prüfen")
    @Description("Überprüft ob der korrekte StatusCode für den Status des Tanks zurückgegeben wird")
    void CheckForCorrectStatusCode(){

        Tank t1 = new Tank();
        StatusCode statusCode = Notifications.GetStatusForTankQuantity(t1.getQuantity());

        if (statusCode.TankPressure <= 49 && statusCode.TankPressure >= 1){
            assertEquals(statusCode.ID, StatusCodes.CriticalUnderpresssure.ID);
        }
        else if (statusCode.TankPressure >= 301 && statusCode.TankPressure <= 501){
            assertEquals(statusCode.ID, StatusCodes.CriticalOverpressure.ID);
        }
        else if(statusCode.TankPressure >= 501){
            assertEquals(statusCode.ID, StatusCodes.DangerAhead.ID);
        }
        else if(statusCode.TankPressure >= 181 && statusCode.TankPressure<= 219){
            assertEquals(statusCode.ID, StatusCodes.OptimalQuantity.ID);
        }
        else if(statusCode.TankPressure >= 50 && statusCode.TankPressure<= 180){
            assertEquals(statusCode.ID, StatusCodes.Underpressure.ID);
        }
        else if(statusCode.TankPressure >= 220){
            assertEquals(statusCode.ID, StatusCodes.Overpressure.ID);
        }
        else {
            assertEquals(statusCode.ID, StatusCodes.StatusError.ID);
        }
    }
}