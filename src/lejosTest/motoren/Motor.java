package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public abstract class Motor {

	protected EV3LargeRegulatedMotor motor;
	
	public Motor(Port port) {
		motor = new EV3LargeRegulatedMotor(port);
	}
}
