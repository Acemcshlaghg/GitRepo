
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.Rectangle;
public class GraphicsPanel extends JPanel implements KeyListener {
	private static Scanner s = new Scanner(System.in);
	private final int SQUARE_HEIGHT = 300; // The width of one space on the board. Constant used for drawing board.
	private final int SQUARE_LENGTH = 300;
	Font f = new Font("serif", Font.PLAIN, 20);

	public GraphicsPanel() {
		setPreferredSize(new Dimension(SQUARE_LENGTH, SQUARE_HEIGHT));
		this.setFocusable(true); // for keylistener
		this.addKeyListener(this);
		

	}

	public void paintComponent(Graphics g) {
		Rectangle r = new Rectangle(150,150,10,10);
		g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
		
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
