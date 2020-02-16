import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class Triangle extends Polygon {
	public Triangle(int[] xPoints, int[] yPoints) {
		this.xpoints[0] = xPoints[0];
		this.xpoints[1] = xPoints[1];
		this.xpoints[2] = xPoints[2];
		this.ypoints[0] = yPoints[0];
		this.ypoints[1] = yPoints[1];
		this.ypoints[2] = yPoints[2];
		this.npoints = 3;
	}

	public int getPeakX() {
		return this.xpoints[0];
	}

	public Triangle newTriangleLeft(int triangleLength) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		for (int x = 0; x < 3; x++) {
			xPoints[x] = this.xpoints[x] - 30;
		}

		yPoints[0] = this.ypoints[1];
		yPoints[1] = this.ypoints[0];
		yPoints[2] = this.ypoints[0];

		return new Triangle(xPoints, yPoints);
	}

	public Triangle newTriangleRight(int triangleLength) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		for (int x = 0; x < 3; x++) {
			xPoints[x] = this.xpoints[x] + 30;
		}

		yPoints[0] = this.ypoints[1];
		yPoints[1] = this.ypoints[0];
		yPoints[2] = this.ypoints[0];

		return new Triangle(xPoints, yPoints);
	}

	public static ArrayList<Triangle> downShifted(ArrayList<Triangle> tris, int triangleLength) {
		ArrayList<Triangle> downShifted = tris;
		for (Triangle t : tris) {
			t.ypoints[1] = t.ypoints[0] + 60 * triangleLength;
			t.ypoints[0] = t.ypoints[2] + 60 * triangleLength;
			t.ypoints[2] = t.ypoints[1];
		}
		return downShifted;
	}

}
