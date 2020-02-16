
// Project: pokerFinal
// Written by: Daniel Rosen
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageFilter;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel implements MouseListener {

	private final int SQUARE_WIDTH = 200; // The width of one space on the board. Constant used for drawing board.
	private Graphics2D g2;
	
	public GraphicsPanel() {
		setPreferredSize(new Dimension(SQUARE_WIDTH, SQUARE_WIDTH)); 
		this.setFocusable(true); // for keylistener
		this.addMouseListener(this);

	}

	// method: paintComponent
	// description: This method will paint the items onto the graphics panel. This
	// method is called when the panel is
	// first rendered. This method also highlights the pieces that the players slect
	// to move in a given turn, and
	// and checks if the game is over by checking for the death of one king and the
	// life of the other,
	// parameters: Graphics g - This object is used to draw your images onto the
	// graphics panel.
	public void paintComponent(Graphics g) {
		}

	@Override
	// method: mouseClicked
	// description: This method is activated when the user clicks anywhere won the
	// board. If the game is not over,
	// the logic checks whose turn it is, and highlights the piece the user clicked
	// on yellow (for white)
	// or blue (for black). When the user clicks the place they wish for their piece
	// to go, this method checks whether it
	// is a valid move, and if the move is valid, the piece is moved. If not, the
	// user can try again.
	public void mouseClicked(MouseEvent e) {
		
	}// end of mouse-clicked

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
