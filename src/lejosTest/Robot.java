package lejosTest;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import lejosTest.factories.FactoryProvider;
import lejosTest.factories.FactoryType;
import lejosTest.factories.MotorFactory;
import lejosTest.factories.MotorType;
import lejosTest.factories.SensorFactory;
import lejosTest.factories.SensorType;
import lejosTest.geometry.GeoShape;
import lejosTest.motoren.AxisMotor;
import lejosTest.motoren.PenMotor;
import lejosTest.sensoren.IRSensor;
import lejosTest.sensoren.TouchSensor;

public class Robot {

	private Geometry geo;
	
	private AxisMotor mConv;
	private AxisMotor mPaper;
	private PenMotor mPen;
	
	private TouchSensor tSen;
	private IRSensor irSen;
	
	public Robot() {
		FactoryProvider fp = new FactoryProvider();
		
		MotorFactory mf = (MotorFactory) fp.getFactory(FactoryType.Motor);
		mConv = (AxisMotor) mf.create(MotorType.Axis, MotorPort.B);
		mPaper = (AxisMotor) mf.create(MotorType.Axis, MotorPort.A);
		mPen = (PenMotor) mf.create(MotorType.Pen, MotorPort.C);
		
		SensorFactory sf = (SensorFactory) fp.getFactory(FactoryType.Sensor);
        tSen = (TouchSensor) sf.create(SensorType.Touch, SensorPort.S1);
        irSen = (IRSensor) sf.create(SensorType.IR, SensorPort.S2);
        
        geo = Geometry.getInstance(mConv, mPaper);
	}
	
	public void preparePrinter() {
		mConv.prepare(tSen);
		mPaper.prepare(irSen);
		Delay.msDelay(2000);
		//mPaper.emitPaper();
	}
	
	public void test() {
		mConv.move(-50);
		mPen.changeState();
		geo.triangle(40, 50);
	}
	
	public void finish() {
		mPen.reset();
		mPaper.emitPaper();
	}
	
	//unused
	public void draw(GeoShape g) {
		
		while(g.getNextPos() != null) {
			
		}
	}
	
}
