package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;
import lejosTest.MathHelper;
import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.Sensor;
import lejosTest.sensoren.TouchSensor;

public class AxisMotor extends EV3LargeRegulatedMotor {

	protected int pos;
	
	public AxisMotor(Port port) {
		super(port);
	}
	
	@Override
	public void setSpeed(int mm) {
		super.setSpeed(MathHelper.toDegrees(mm));
	}
	
	public void prepare(Sensor sen) {
		setSpeed(30);
		
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
		rotate(MathHelper.toDegrees(100));
	}
	
	public void move(int mm) {
		rotate(MathHelper.toDegrees(mm));
	}
	
	
	
}
