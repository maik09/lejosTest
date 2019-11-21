package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;
import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.Sensor;
import lejosTest.sensoren.TouchSensor;

public class AxisMotor extends EV3LargeRegulatedMotor {

	protected int diameterMM = 39;
	double degPerMM = 360 / diameterMM;
	protected int pos;
	
	public AxisMotor(Port port) {
		super(port);
	}
	
	@Override
	public void setSpeed(int mm) {
		super.setSpeed(toDegrees(mm));
	}
	
	/*
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
	*/
	
	public void prepare(Sensor sen) {
		setSpeed(10);
		
		if (sen instanceof TouchSensor) {
			TouchSensor tSen = (TouchSensor) sen;
			
			if (tSen.getValue() == 0) {
				forward();
				tSen.waitForTouch();
			}
		}
		else if (sen instanceof IRSensor) {
			IRSensor irSen = (IRSensor) sen;
			forward();
			irSen.check();
		}
		
		stop();
		
		//Tacho Reset
		resetTachoCount();
		pos = 0;
	}
	
	public void emitPaper() {
		rotate(toDegrees(200));
	}
	
	public void move(int mm) {
		rotate(toDegrees(mm));
	}
	
	protected int toDegrees(int mm) {
		double degree = degPerMM * mm;
		return (int) degree;
	}
	
}
