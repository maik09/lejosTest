package lejosTest.factories;

import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.Sensor;
import lejosTest.sensoren.TouchSensor;


public class SensorFactory implements AbstractFactory<Sensor, SensorType> {

	public Sensor create(SensorType type) {
		
		if(type == SensorType.IR)
			return new IRSensor();
		else
			return new TouchSensor();
	}
}
