package lejosTest.sensoren;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class TouchSensor extends Sensor {

	private EV3TouchSensor touch;
	private SampleProvider sp;
	
	public TouchSensor(Port port) {
		super(port);
		touch = new EV3TouchSensor(port);
	}
	
	public void waitForTouch() {
		sp = touch.getTouchMode();
		int touchVal = 0;
		while (touchVal == 0) {
			float[] sample = new float[sp.sampleSize()];
	        sp.fetchSample(sample, 0);
	        touchVal = (int) sample[0];
		}
	}

}
