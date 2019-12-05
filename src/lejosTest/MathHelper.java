package lejosTest;

public class MathHelper {

	private static int diameterMM = 39;
	private static double degPerMM = 360 / diameterMM;
	
	public static int toDegrees(int mm) {
		double degree = degPerMM * mm;
		return (int) degree;
	}
}
