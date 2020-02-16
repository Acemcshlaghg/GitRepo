import java.util.ArrayList;

public class Table {
	// instance variables
	private ArrayList<Card> board;
	private int pot;

	public Table() {
		this(new ArrayList<>(), 0);
	}

	public Table(ArrayList<Card> cards, int pot) {
		this.board = cards;
		this.pot = pot;
	}

	// accessors(getters)
	public ArrayList<Card> getBoard() {
		return board;
	}

	public int getPot() {
		return pot;
	}

	// modifiers(setters)
	public void setBoard(ArrayList<Card> board) {
		this.board = board;
	}
	public void addCard(Card c) {
		this.board.add(c);
	}

	public void setPot(int pot) {
		this.pot = pot;
	}

	// methods
	public boolean isInBoard(String rank) {
		for (Card c : board) {
			if (c.getRank().equals(rank)) {
				return true;
			}
		} // end of loop
		return false;
	}

}
