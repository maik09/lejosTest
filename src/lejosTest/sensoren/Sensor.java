package lejosTest.sensoren;

import lejos.hardware.port.Port;

public abstract class Sensor {

	private Port port;
	private int value;
	
	public Sensor(Port port) {
		this.port = port;
	}
	
	public int getValue() {
		return value;
	}

}
