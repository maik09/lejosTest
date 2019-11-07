package lejosTest.factories;

public class FactoryProvider {

	public AbstractFactory getFactory(FactoryType type) {
		
		if(type == FactoryType.Motor)
			return new MotorFactory();
		else
			return new SensorFactory();
	}
}
