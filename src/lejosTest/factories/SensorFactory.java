package lejosTest.factories;

import lejos.hardware.port.Port;
import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.Sensor;
import lejosTest.sensoren.TouchSensor;


public class SensorFactory implements AbstractFactory<Sensor, SensorType> {

	public Sensor create(SensorType type, Port port) {
		
		if(type == SensorType.IR)
			return new IRSensor(port);
		else
			return new TouchSensor(port);
	}
}
