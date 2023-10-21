package challenge;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class Challenge4Test {

    @Test
    public void testChangeLight(){
        CarSensor carSensor = Mockito.mock(CarSensor.class);
        PedestrianSensor pedestrianSensor = Mockito.mock(PedestrianSensor.class);

        TrafficLight trafficLight = new TrafficLight(carSensor, pedestrianSensor);

        when(carSensor.isCarDetected()).thenReturn(true);
        when(pedestrianSensor.isPedestrianDetected()).thenReturn(false);

        trafficLight.changeLight();

        Mockito.verify(carSensor, times(1)).isCarDetected();
        Mockito.verify(pedestrianSensor,times(1)).isPedestrianDetected();

    }
}
