package lejosTest.factories;

public interface AbstractFactory<E, Type> {

	public E create(Type t);
}