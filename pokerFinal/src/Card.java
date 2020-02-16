
public class Card {
	// instance variables
	private String suit;
	private String rank;

	// constructors
	public Card() {
		this("hearts", "2");
	}

	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	// accessors(getters)
	public String getSuit() {
		return suit;

	}

	public String getRank() {
		return rank;
	}

	// modifiers(setters)
	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	// methods
	public String toString() {
		char suitSymbol;
		return "|" + rank + " " + suit + "|";
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
