import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

//Project : CheckerboardNN
public class NueralNetwork {
	private ArrayList<Nueron[]> allNuerons;
	private Color[] board;

	public NueralNetwork(Color[] board) {
		this.allNuerons = new ArrayList<>();
		this.setBoard(board);
	}

	public void think() {
		// initializes the structure of the three layers
		Nueron[] il = { new Nueron(board[0]), new Nueron(board[1]), new Nueron(board[2]), new Nueron(board[3]) };// InputLayer
		Nueron[] hl1 = { new Nueron(il[0], il[1]), new Nueron(il[0], il[2]), new Nueron(il[1], il[3]),
				new Nueron(il[2], il[3]) };// Hidden Layer1
		Nueron[] hl2 = { new Nueron(hl1[0], hl1[1]), new Nueron(hl1[0], hl1[2]), new Nueron(hl1[1], hl1[3]) };// HiddenLayer2
		Nueron[] ol = { new Nueron(hl2[0], hl2[1], hl2[2]), new Nueron(hl2[0], hl2[1], hl2[2]) };// OutputLayer

		// gives coordinates to each Nueron
		for (int i = 0; i < il.length; i++) {
			il[i].setPoint(new Point(200, 15 + 75 * i));
		}
		for (int i = 0; i < hl1.length; i++) {
			hl1[i].setPoint(new Point(300, 30 + 60 * i));
		}
		for (int i = 0; i < hl2.length; i++) {
			hl2[i].setPoint(new Point(400, 20 + 100 * i));
		}
		for (int i = 0; i < ol.length; i++) {
			ol[i].setPoint(new Point(500, 85 + 100 * i));
		}

		// adds neurons to allNuerons
		allNuerons.add(il);
		allNuerons.add(hl1);
		allNuerons.add(hl2);
		allNuerons.add(ol);

		// Prints Values
		System.out.print("Input: ");
		for (int i = 0; i < il.length; i++) {
			System.out.print(il[i].getValue() + " ");
		}
		System.out.println();
		System.out.print("Hidden1: ");
		for (int i = 0; i < hl1.length; i++) {
			System.out.print(hl1[i].getValue() + " ");

		}
		System.out.println();
		System.out.print("Hidden2: ");
		for (int i = 0; i < hl2.length; i++) {
			System.out.print(hl2[i].getValue() + " ");

		}
		System.out.println();
		System.out.print("Output: ");

		for (int i = 0; i < ol.length; i++) {
			System.out.print(ol[i].getValue() + " ");
		}
		System.out.println();
	}

	public static String checkWork(Color[] board, int toBeChecked) {
		if (((board[0] == Color.black && board[2] == Color.black && board[1] == Color.white && board[3] == Color.white)
				|| (board[0] == Color.white && board[2] == Color.white && board[1] == Color.black
						&& board[3] == Color.black))
				&& toBeChecked == 1) {
			return "right";
		} else if (toBeChecked == 1) {
			return "wrong";
		} else {
			return "right";
		}
	}

	public ArrayList<Nueron[]> getAllNuerons() {
		return allNuerons;
	}

	public void setAllNuerons(ArrayList<Nueron[]> allNuerons) {
		this.allNuerons = allNuerons;
	}

	public Color[] getBoard() {
		return board;
	}

	public void setBoard(Color[] board) {
		this.board = board;
	}
}
