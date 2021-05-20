package KawumAG;

// Fake Drucksensor, bei dem der Druck nicht ausgelesen werden muss, sondern im Code
// gesetzt werden kann. Wird zum testen von verschiedenen Druckwerten benutzt
public class FakePressureSensor implements IReadPressure {

    @Override
    public double readPressure() {
        return pressure;
    }

    private double pressure;

    public void setPressure(double p){
        pressure = p;
    }
}
