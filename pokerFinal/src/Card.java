
public class Card {
	// instance variables
	private int suit;
	private int rank;

	// constructors
	public Card() {
		this(1, 1);
	}

	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	// accessors(getters)
	public int getSuit() {
		return suit;

	}

	public int getRank() {
		return rank;
	}

	// modifiers(setters)
	public void setSuit(int suit) {
		this.suit = suit;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// methods
	public String toString() {
		char suitSymbol;
		return "|" + HandInfo.intToRank(rank) + " " + HandInfo.intToSuit(suit) + "|";
	}

	public boolean passedHasHigherRank(Card c, String[] ranks) {// returns true if the card passed has higher rank
		for (int i = 0; i < ranks.length; i++) {
			if (ranks[i].equals(rank)) {
				return true;
			} else if (ranks[i].equals(c.getRank())) {
				return false;
			}
		}
		return false;
	}
}
