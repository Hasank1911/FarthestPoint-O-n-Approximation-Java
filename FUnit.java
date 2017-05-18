import java.awt.Point;
import java.text.DecimalFormat;
import java.util.Random;

public class FUnit {
	
	static DecimalFormat df = new DecimalFormat("0.##");
	
	public static void main(String[] args) {

		Point[] data = generate(); // generate random points.
		System.out.println(bruteForce(data)); // for testing
		System.out.println(approximation(data));

	}

	private static String approximation(Point[] data) {
		int length = data.length;
		int currentFirstOne = 0;
		int currentSecondOne = 1;
		double maxDistance = 0; // just for reporting

		for (int i = 2; i < length; i++) {
			double distanceWithFirst = Distance(data[i], data[currentFirstOne]);
			double distanceWithSecond = Distance(data[i], data[currentSecondOne]);
			double currentDistance = Distance(data[currentFirstOne], data[currentSecondOne]);

			if (distanceWithFirst > currentDistance && distanceWithFirst > distanceWithSecond) { // best pair is currentFirstOne-i
				currentSecondOne = i;
				maxDistance = distanceWithFirst; 
			} else if (distanceWithSecond > currentDistance && distanceWithSecond > distanceWithFirst) { // best pair is currentSecondOne-i
				currentFirstOne = i;
				maxDistance = distanceWithSecond;
			} else {
				maxDistance = currentDistance;
			}

		}

		return "Approximation:        " + currentFirstOne + " " + currentSecondOne + " with distance " + df.format(maxDistance);
	}

	private static String bruteForce(Point[] data) {
		int length = data.length;
		double max = 0;
		int maxIndexOne = -1;
		int maxIndexTwo = -1;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (Distance(data[i], data[j]) > max) {
					max = Distance(data[i], data[j]);
					maxIndexOne = i;
					maxIndexTwo = j;
				}
			}
		}
		return "Real farthest points: " + maxIndexOne + " " + maxIndexTwo + " with distance " + df.format(max);
	}

	private static Point[] generate() {
		Random rand = new Random();
		int dataLength = 20 + rand.nextInt(20);
		Point[] data = new Point[dataLength];

		for (int i = 0; i < dataLength; i++) {
			data[i] = new Point(rand.nextInt(40), rand.nextInt(40));
		}
		return data;
	}

	private static double Distance(Point a, Point b) { // Note : there is no need to use sqrt if we only need to compare distances.
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)); 
	}
}
