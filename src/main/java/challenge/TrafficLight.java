package challenge;

class CarSensor{
    private boolean carDetected;

    public void setCarDetected (boolean carDetected){
        this.carDetected = carDetected;
    }
    public boolean isCarDetected(){
        return carDetected;
    }
}

class PedestrianSensor{
    private boolean pedestrianDetected;

    public void setPedestrianDetected(boolean pedestrianDetected){
        this.pedestrianDetected = pedestrianDetected;
    }
    public boolean isPedestrianDetected(){
        return pedestrianDetected;
    }
}
public class TrafficLight {
    private CarSensor carSensor;
    private PedestrianSensor pedestrianSensor;

    public TrafficLight(CarSensor carSensor, PedestrianSensor pedestrianSensor) {
        this.carSensor = carSensor;
        this.pedestrianSensor = pedestrianSensor;
    }

    public void changeLight() {
        boolean carDetected = carSensor.isCarDetected();
        boolean pedestrianDetected = pedestrianSensor.isPedestrianDetected();

        if (carDetected && pedestrianDetected) {
            System.out.println("Traffic light is red.");
        } else if (carDetected) {
            System.out.println("Traffic light is yellow.");
        } else if (pedestrianDetected) {
            System.out.println("Traffic light is yellow.");
        } else {
            System.out.println("Traffic light is green.");
        }
    }
}
