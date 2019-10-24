package lejosTest;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

public class Functions {
	
	private SampleProvider sp;
	
	public void waitForTouch(EV3TouchSensor touch) {
		sp = touch.getTouchMode();
		while (getTouchVal() == 0) {}
	}
	
	public int getTouchVal() {
		float[] sample = new float[sp.sampleSize()];
        sp.fetchSample(sample, 0);
        return (int) sample[0];
	}

}
