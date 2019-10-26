
// Project: CheckerboardNN
// Written by: Daniel Rosen
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	private final int SQUARE_HEIGHT = 300; // The width of one space on the board. Constant used for drawing board.
	private final int SQUARE_LENGTH = 700;

	Font f = new Font("serif", Font.PLAIN, 20);

	public GraphicsPanel() {
		setPreferredSize(new Dimension(SQUARE_LENGTH, SQUARE_HEIGHT));
		this.setFocusable(true); // for keylistener
		this.addKeyListener(this);

	}

	public void paintComponent(Graphics g) {

		Color[] board = new Checkerboard().getBoard();// initializes a new Checkerboard
		NueralNetwork net = new NueralNetwork(board);
//		draws background for board
		g.setColor(Color.blue);
		g.fillRect(28, 28, 54, 208);

//			uses neural network
		net.think();
//		draws board
		for (int i = 0; i < 4; i++) {

			g.setColor(board[i]);
			g.fillRect(30, 30 + 51 * i, 50, 50);
			g.setColor(Color.red);
			g.drawLine(55, 55 + 51 * i, (int) net.getAllNuerons().get(0)[i].getPoint().getX() + 15,
					(int) net.getAllNuerons().get(0)[i].getPoint().getY() + 15);
		} // end of for loop

//			draws links between neurons
		for (int layer = 1; layer < net.getAllNuerons().size(); layer++) {// iterates through layers of network
			for (Nueron n : net.getAllNuerons().get(layer)) {// iterates through neurons in layer
				for (Nueron nInput : n.getInput()) {// iterates through input neurons
					if (nInput.getValue() >= 0.5) {
						g.setColor(Color.red);
					} else {
						g.setColor(Color.green);
					}
					g.drawLine((int) nInput.getPoint().getX() + 15, (int) nInput.getPoint().getY() + 15,
							(int) n.getPoint().getX() + 15, (int) n.getPoint().getY() + 15);
				}
			}
		} // end of for loop

//			draws neurons
		g.setColor(Color.blue);
		for (Nueron[] ns : net.getAllNuerons()) {
			for (Nueron n : ns) {
				g.fillOval((int) n.getPoint().getX(), (int) n.getPoint().getY(), 30, 30);// neuron
				g.drawString(Double.toString(n.getValue()), (int) n.getPoint().getX(), (int) n.getPoint().getY());// value
			}
		}
		
		//train network
		
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
