package lejosTest.factories;

import lejos.hardware.port.Port;

public interface AbstractFactory<E, Type> {

	public E create(Type t, Port port);
}