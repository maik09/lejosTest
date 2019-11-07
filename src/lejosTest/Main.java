package lejosTest;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import lejosTest.factories.AbstractFactory;
import lejosTest.factories.FactoryProvider;
import lejosTest.factories.FactoryType;
import lejosTest.factories.MotorFactory;
import lejosTest.factories.MotorType;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.Motor;
import lejos.hardware.lcd.LCD;

public class Main {

	/*
	public static void newSpeed(double mmPerSec, EV3LargeRegulatedMotor motor) {
		//double radius = 0.02;
		//double perimm = 2 * Math.PI * radius * 1000;
		double perimm = 40;
		double degPerMM = 360 / perimm;
		motor.setSpeed((int) (degPerMM * mmPerSec));
	}
	
	public static void move(int mm, double mmPerSec, boolean forward, EV3LargeRegulatedMotor motor) {
		newSpeed(mmPerSec, motor);
		
		if (forward)
			motor.forward();
		else
			motor.backward();
	}
	
	public static void moveDelay(int mm, double mmPerSec, boolean forward, EV3LargeRegulatedMotor motor) {
		move(mm, mmPerSec, forward, motor);
		Delay.msDelay((int) (mm / mmPerSec) * 1000);
	}
	*/
	
	public static void moveHypo(int x1, int x2, int y1, int y2, int time, EV3LargeRegulatedMotor mConv, EV3LargeRegulatedMotor mPaper) 
	{
		int xdiff = x2 - x1;
		int ydiff = y2 - y1;
		
		double speedX = xdiff / (time/1000);
		double speedY = ydiff / (time/1000);
		
		move(xdiff, speedX, false, mConv);
		move(ydiff, speedY, false, mPaper);
		
		Delay.msDelay(time);
	}
	
	public static void initHypo(int x, int y, int time, EV3LargeRegulatedMotor mConv, EV3LargeRegulatedMotor mPaper) 
	{
		moveHypo(0, x, 0, y, time, mConv, mPaper);
	}
	
	
	public static void main(String[] args) 
	{
		Functions f = new Functions();
		
		Port portConv = MotorPort.A;
		Port portPaper = MotorPort.B;
		Port portPenLift = MotorPort.C;
		
		Port portTouch = SensorPort.S1;
		Port portIR = SensorPort.S2;
		
		final EV3LargeRegulatedMotor mConv = new EV3LargeRegulatedMotor(portConv);
        final EV3LargeRegulatedMotor mPaper = new EV3LargeRegulatedMotor(portPaper);
        final EV3LargeRegulatedMotor mPenLift = new EV3LargeRegulatedMotor(portPenLift);
        
        final EV3TouchSensor touch = new EV3TouchSensor(portTouch);
        final EV3IRSensor ir = new EV3IRSensor(portIR);
		
        //start
        
        // X auf 0
        mConv.setSpeed(500);
        mConv.forward();
        f.waitForTouch(touch);
        mConv.stop();
        
        
        initHypo(50, 80, 5000, mConv, mPaper);
        //moveDelay(100, 10, true, mPaper);
        
        LCD.drawString("Gehe zurueck...", 0, 4);
        Delay.msDelay(1000);
        
        //move(100, 10, false, mConv);
        FactoryProvider fp = new FactoryProvider();
        AbstractFactory mf = fp.getFactory(FactoryType.Motor);
        AxisMotor motor = (AxisMotor) mf.create(MotorType.Axis);
	
	}

}
