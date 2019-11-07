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
import lejosTest.factories.SensorType;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.Motor;
import lejosTest.motoren.PenMotor;
import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.TouchSensor;
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
	
	/*
	
	public static void moveHypo(int x1, int x2, int y1, int y2, int mmPerSec, EV3LargeRegulatedMotor mConv, EV3LargeRegulatedMotor mPaper) 
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
	*/
	
	public static void main(String[] args) 
	{
		FactoryProvider fp = new FactoryProvider();
        AbstractFactory mf = fp.getFactory(FactoryType.Motor);
        AbstractFactory sf = fp.getFactory(FactoryType.Sensor);
        
        AxisMotor mConv = (AxisMotor) mf.create(MotorType.Axis, MotorPort.A);
        AxisMotor mPaper = (AxisMotor) mf.create(MotorType.Axis, MotorPort.B);
        PenMotor mPen = (PenMotor) mf.create(MotorType.Pen, MotorPort.C);
        
        TouchSensor tSen = (TouchSensor) sf.create(SensorType.Touch, SensorPort.S1);
        IRSensor irSen = (IRSensor) sf.create(SensorType.IR, SensorPort.S2);
		
        //start
        
        mConv.moveRot(50);
        
        // X auf 0
       // f.waitForTouch(touch);
        
        //initHypo(50, 80, 5000, mConv, mPaper);
        //moveDelay(100, 10, true, mPaper);
        
        LCD.drawString("Gehe zurueck...", 0, 4);
        Delay.msDelay(1000);
        
        //move(100, 10, false, mConv);
        
	}

}
