package lejosTest;

import lejos.hardware.port.MotorPort;
import lejosTest.factories.FactoryProvider;
import lejosTest.factories.FactoryType;
import lejosTest.factories.MotorFactory;
import lejosTest.factories.MotorType;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.Motor;

public class Robot {

	private AxisMotor m1;
	
	public Robot() {
		FactoryProvider fp = new FactoryProvider();
		MotorFactory mf = (MotorFactory) fp.getFactory(FactoryType.Motor);
		m1 = (AxisMotor) mf.create(MotorType.Axis, MotorPort.A);
	}
	
	public void prog1() {
		m1.move(5, 10, true);
	}
	
	
}
