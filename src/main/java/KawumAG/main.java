package KawumAG;

class Main {
    public static void main (String[] args) {

        PressureSensor sensor = new PressureSensor();
        Tank t1 = new Tank(sensor);

        double tankPressure = t1.getPressure();

        PersonRole personrole = new PersonRole();

        System.out.print(
                Notifications.GetTankPressure(tankPressure, personrole.getRandomPerson()));
    }
}
