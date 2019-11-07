package lejosTest.sensoren;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;

public class IRSensor extends Sensor {

	private EV3IRSensor ir;
	
	public IRSensor(Port port) {
		super(port);
		ir = new EV3IRSensor(port);
	}

}
