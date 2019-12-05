package lejosTest.factories;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.PenMotor;

public class MotorFactory implements AbstractFactory<EV3LargeRegulatedMotor, MotorType> {
	
	public EV3LargeRegulatedMotor create(MotorType type, Port port) {
		if (type == MotorType.Axis)
			return new AxisMotor(port);
		else
			return new PenMotor(port);
	}
}
