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
		final EV3LargeRegulatedMotor mA = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor mB = new EV3LargeRegulatedMotor(MotorPort.B);
        final EV3LargeRegulatedMotor mC = new EV3LargeRegulatedMotor(MotorPort.C);

        final EV3TouchSensor touch1 = new EV3TouchSensor(SensorPort.S2);
        final SampleProvider sp = touch1.getTouchMode();
        int touchValue = 0;

        /*
        System.out.println("Motor B");
        mB.setSpeed(500);
        mB.forward();
        Delay.msDelay(DELAY);
        mB.stop();
        */

        
        mB.setSpeed(500);
        mB.forward();
        
        while (touchValue == 0) {
            float[] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            touchValue = (int) sample[0];
            //System.out.println(touchValue);
        }
        mB.stop();
        
        mB.backward();
        Delay.msDelay(2000);
        mB.stop();

	}

}
