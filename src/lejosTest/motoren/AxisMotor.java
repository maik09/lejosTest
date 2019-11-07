package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class AxisMotor extends Motor {

	public AxisMotor(Port port) {
		super(port);
	}
	
	public void moveInf(int mm, double mmPerSec, boolean forward) {
		newSpeed(mmPerSec, motor);
		
		if (forward)
			motor.forward();
		else
			motor.backward();
	}
	
	public void move(int mm, double mmPerSec, boolean forward) {
		moveInf(mm, mmPerSec, forward);
		Delay.msDelay((int) (mm / mmPerSec) * 1000);
	}
	
	private void newSpeed(double mmPerSec, EV3LargeRegulatedMotor motor) {
		//double radius = 0.02;
		//double perimm = 2 * Math.PI * radius * 1000;
		double perimm = 40;
		double degPerMM = 360 / perimm;
		motor.setSpeed((int) (degPerMM * mmPerSec));
	}
}
