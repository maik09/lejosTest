package lejosTest.motoren;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;

public class PenMotor extends EV3LargeRegulatedMotor {

	private boolean down = false;
	
	public PenMotor(Port port) {
		super(port);
	}
	
	public void changeState() {
		rotate(180);
		if (down)
			down = false;
		else
			down = true;
	}
	
	public void reset() {
		if (down)
			changeState();
	}

}
