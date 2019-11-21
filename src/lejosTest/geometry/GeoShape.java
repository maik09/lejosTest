package lejosTest.geometry;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GeoShape {

	ArrayList<Point2D> pos = new ArrayList<Point2D>();
	
	public Point2D getNextPos() {
		Point2D temp = pos.get(0);
		try {
			pos.remove(0);
		}
		catch (NullPointerException e) {
			return null;
		}
		return temp;
	}
}
