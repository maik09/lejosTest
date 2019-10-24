package lejosTest;

import java.util.Scanner;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.lcd.LCD;

public class Main {

	public static void newSpeed(int mmPerSec, EV3LargeRegulatedMotor motor) {
		//double radius = 0.02;
		//double perimm = 2 * Math.PI * radius * 1000;
		double perimm = 40;
		double degPerMM = 360 / perimm;
		motor.setSpeed((int) (degPerMM * mmPerSec));
	}
	
	public static void move(int mm, int mmPerSec, boolean forward, EV3LargeRegulatedMotor motor) {
		newSpeed(mmPerSec, motor);
		
		if (forward)
			motor.forward();
		else
			motor.backward();
		
		Delay.msDelay((int) (mm / mmPerSec) * 1000);
	}
	
	public static void moveHypo(int x, int y, int mmPerSec, EV3LargeRegulatedMotor mConv, EV3LargeRegulatedMotor mPaper) {
		move(x, mmPerSec, true, mConv);
		double percent = 1;
		if (x > y)
			percent = y / x;
		else
			percent = x / y;
		
		move(y,(int) (mmPerSec * percent), true, mPaper);
		
		double hypo = Math.sqrt((x*x) + (y*y));
		Delay.msDelay((int) (hypo / mmPerSec) * 1000);
		mConv.stop();
		mPaper.stop();
	}
	
	public static void main(String[] args) 
	{
		Functions f = new Functions();
		Scanner sc = new Scanner(System.in);
		
		Port portConv = MotorPort.B;
		Port portPaper = MotorPort.A;
		Port portPenLift = MotorPort.C;
		
		Port portTouch = SensorPort.S2;
		Port portIR = SensorPort.S1;
		
		final EV3LargeRegulatedMotor mConv = new EV3LargeRegulatedMotor(portConv);
        final EV3LargeRegulatedMotor mPaper = new EV3LargeRegulatedMotor(portPaper);
        final EV3LargeRegulatedMotor mPenLift = new EV3LargeRegulatedMotor(portPenLift);
        
        final EV3TouchSensor touch = new EV3TouchSensor(portTouch);
        final EV3IRSensor ir = new EV3IRSensor(portIR);

        //start
        
        //move(100, 10, true, mConv);
        
        moveHypo(20, 10, 20, mConv, mPaper);
        /*
        f.waitForTouch(touch);
        mConv.stop();
        
        LCD.drawString("Gehe zurueck...", 0, 4);
        Delay.msDelay(1000);
        
        mConv.backward();
        Delay.msDelay(2000);
        mConv.stop();
	*/
	}

}
