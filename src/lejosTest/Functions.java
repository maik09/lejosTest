package lejosTest;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class Functions {
	
	private SampleProvider sp;
	
	public void waitForTouch(EV3TouchSensor touch) {
		sp = touch.getTouchMode();
		int touchVal = 0;
		while (touchVal == 0) {
			float[] sample = new float[sp.sampleSize()];
	        sp.fetchSample(sample, 0);
	        touchVal = (int) sample[0];
		}
	}

}
