
// Project: CheckerboardNN
// Written by: Daniel Rosen
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageFilter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.Math;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements KeyListener {
	private static Scanner s = new Scanner(System.in);
	private final int SQUARE_LENGTH = 500;

	Font f = new Font("serif", Font.PLAIN, 20);

	public GraphicsPanel() {
		setPreferredSize(new Dimension(SQUARE_LENGTH, SQUARE_LENGTH));
		this.setFocusable(true); // for keylistener
		this.addKeyListener(this);
		
	}

	public void paintComponent(Graphics g) {
		ArrayList<ArrayList<Triangle>> allTris = new ArrayList<ArrayList<Triangle>>();
		int numRows = 6;
		int[] xPoints = {250, 220, 280};
		int[] yPoints = {10, 70, 70};
		Triangle tri1 = new Triangle(xPoints, yPoints);
		
		for(int row = 1; row <= numRows; row++) {
			ArrayList<Triangle> tris = new ArrayList<Triangle>();
			tris.add(tri1);
			while(tris.size() < 2 * row - 1) {//adds triangles
				tris.add(0, tris.get(0).newTriangleLeft(1));
				tris.add(tris.get(tris.size() - 1).newTriangleRight(1));
			}
			
			for(Triangle t: tris) {//draws triangles
				g.drawPolygon(t.xpoints, t.ypoints, 3);
			}
			tris = Triangle.downShifted(tris, 1);

		}
		
	}// end of paintComponent

	@Override
	public void keyPressed(KeyEvent key) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
