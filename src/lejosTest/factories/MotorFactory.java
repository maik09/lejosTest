package lejosTest.factories;

import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.Motor;
import lejosTest.motoren.PenMotor;

public class MotorFactory implements AbstractFactory<Motor, MotorType> {
	
	public Motor create(MotorType type) {
		if (type == MotorType.Axis)
			return new AxisMotor();
		else
			return new PenMotor();
	}
}
