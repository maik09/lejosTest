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

	public void move(int mmsec, Port motorPort) {
		
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
        
        mConv.setSpeed(500);
        mConv.forward();
        
        f.waitForTouch(touch);
        mConv.stop();
        
        LCD.drawString("Gehe zurueck...", 0, 4);
        Delay.msDelay(1000);
        
        mConv.backward();
        Delay.msDelay(2000);
        mConv.stop();

	}

}
