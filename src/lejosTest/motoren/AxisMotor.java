package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class AxisMotor extends Motor {

	protected int diameterMM = 39;
	
	public AxisMotor(Port port) {
		super(port);
	}
	
	public void move(int mm, double mmPerSec, boolean forward) {
		moveInf(mmPerSec, forward);
		Delay.msDelay((int) (mm / mmPerSec) * 1000);
	}
	
	public void moveInf(double mmPerSec, boolean forward) {
		newSpeed(mmPerSec, motor);
		
		if (forward)
			motor.forward();
		else
			motor.backward();
	}
	
	private void newSpeed(double mmPerSec, EV3LargeRegulatedMotor motor) {
		//double radius = 0.02;
		//double perimm = 2 * Math.PI * radius * 1000;
		double degPerMM = 360 / diameterMM;
		motor.setSpeed((int) (degPerMM * mmPerSec));
	}
	
	public void moveRot(int mm) {
		motor.rotate(toDegrees(mm));
	}
	
	protected int toDegrees(int mm) {
		double degPerMM = 360 / diameterMM;
		double degree = degPerMM * mm;
		return (int) degree;
	}
	
}
