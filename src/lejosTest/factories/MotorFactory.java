package lejosTest.factories;

import lejos.hardware.port.Port;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.Motor;
import lejosTest.motoren.PenMotor;

public class MotorFactory implements AbstractFactory<Motor, MotorType> {
	
	public Motor create(MotorType type, Port port) {
		if (type == MotorType.Axis)
			return new AxisMotor(port);
		else
			return new PenMotor(port);
	}
}
