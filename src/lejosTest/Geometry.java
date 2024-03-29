package lejosTest;

import lejos.robotics.RegulatedMotor;
import lejosTest.motoren.AxisMotor;

public class Geometry {

	private static Geometry geometry = null;
	private AxisMotor mConv;
	private AxisMotor mPaper;
	
	private Geometry(AxisMotor mConv, AxisMotor mPaper) {
		this.mConv = mConv;
		this.mPaper = mPaper;
	}
	
	public static Geometry getInstance(AxisMotor mConv, AxisMotor mPaper) {
		if (geometry == null) {
			geometry = new Geometry(mConv, mPaper);
		}
		return geometry;
	}
	
	public void line(int mm, boolean orientation, boolean forward) {
			
		int factor = -1;
		if (!forward)
			factor = 1;
		
		if (orientation)
			mConv.move(factor * mm);
		else
			mPaper.move(factor * mm);
	}
	
	public void hypo(int x, int y) {
		
		//Speeds
		double percentage = (double) y/x;
		int speedX = 5;
		int speedY = (int) (speedX * percentage);
		System.out.print(speedY);
		mConv.setSpeed(speedX);
		mPaper.setSpeed(speedY);
		
		//Synchro
		mConv.synchronizeWith(new RegulatedMotor[] { mPaper });
		mConv.startSynchronization();
		
		line(x, true, true);
		line(y, false, true);
		
		mConv.endSynchronization();
		mConv.waitComplete();
		mPaper.waitComplete();
	}
	
	public void triangle(int x, int y) {
		hypo(x, y);
		line(y, false, false);
		line(x, true, false);
	}
}
