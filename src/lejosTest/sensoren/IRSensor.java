package lejosTest.sensoren;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

public class IRSensor extends Sensor {

	private EV3IRSensor ir;
	
	public IRSensor(Port port) {
		super(port);
		ir = new EV3IRSensor(port);
	}
	
	public void check() {
		final SampleProvider sp = ir.getDistanceMode();
		int distanceValue = 100;
		
		while(distanceValue != 0) {
		    distanceValue = getValue();
		}
	}
	
	public int getValue() {
		final SampleProvider sp = ir.getDistanceMode();
		float [] sample = new float[sp.sampleSize()];
	    sp.fetchSample(sample, 0);
	    return (int)sample[0];
	}

}
