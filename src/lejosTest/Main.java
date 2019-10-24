package lejosTest;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) 
	{
		Functions f = new Functions();
		
		final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
        final EV3LargeRegulatedMotor mC = new EV3LargeRegulatedMotor(MotorPort.C);
        final EV3LargeRegulatedMotor mC = new EV3LargeRegulatedMotor(MotorPort.D);

        mB.setSpeed(500);
        mB.forward();
        
        final EV3TouchSensor touch1 = new EV3TouchSensor(SensorPort.S2);
        f.initTouch(touch1);
        
        while (f.getTouchVal() == 0) {}
        mB.stop();
        
        mB.backward();
        Delay.msDelay(2000);
        mB.stop();

	}

}
