import java.util.ArrayList;

public class HandInfo {
	private static int[] suitChances = { 13, 13, 13,
			13 };/* {heart, diamond, spade, club}->chances that a suit will be dealt */
	private static int[] rankChances = { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
	private static String[] suits = { "hearts", "diamonds", "spades", "clubs" };
	private static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private static String[] handStrengths = { "Royal Flush", "Straight Flush", "Four of a Kind", "Full house", "Flush",
			"Straight", "Three of a Kind", "Two Pair", "Pair", "High Card" };
	private static int cardsLeft = 52;
	private static int ante = 10;
	private static ArrayList<Card> usedCards = new ArrayList<>();

	public static Card dealCard() {
		int suit = ((int) (Math.random() * suits.length));
		int rank = ((int) (Math.random() * ranks.length));
		Card c = new Card(suit, rank);
		if (usedCards.size() > 0) {
			for (Card used : usedCards) {
				if (c.getRank() == used.getRank() && c.getSuit() == used.getSuit()) {
					return dealCard();
				}
			}
		}
		cardsLeft--;
		rankChances[rank]--;
		suitChances[suit]--;
		usedCards.add(c);
		return c;
	}

	public static String intToSuit(int suit) {
		return suits[suit];
	}

	public static String intToRank(int rank) {
		return ranks[rank];
	}

	public static int rankToInt(String rank) {
		for (int i = ranks.length - 1; i >= 0; i--) {
			if (rank.equals(ranks[i])) {
				return i;
			}
		}
		return -1;
	}

	public static int suitToInt(String suit) {
		for (int i = suits.length - 1; i >= 0; i--) {
			if (suit.equals(suits[i])) {
				return i;
			}
		}
		return 0;
	}

	public static String printHand(Player p) {
		return p.getHand()[0].toString() + "" + p.getHand()[1].toString();
	}

	public static String handStrength(Player p, Table t) {
		ArrayList<Card[]> dupList = simplifyDups(p, duplicates(p, t));
		checkPairs(p, t);
		checkThreeOfaKind(p, dupList);
		checkStraight(p, t);
		checkFlush(p, t);
		checkFullHouse(p, dupList);
		checkFourOfaKind(p, dupList);

		if (checkStraight(p, t) && checkFlush(p, t) && p.getHandStrengthNum() == 11) {// checks straight flush
			p.setHandStrength(handStrengths[0]);
		} else if (checkStraight(p, t) && checkFlush(p, t)) {
			p.setHandStrength(handStrengths[1]);
		}
		int handRank = highRank(p, t);
		if (p.getHandStrengthNum() != 20) {
			handRank = p.getHandStrengthNum();
		}
		switch (p.getHandStrength()) {
		case "Royal Flush":
			return p.getHandStrength();
		case "Four of a Kind":
			return "Four " + ranks[handRank] + "s";
		case "Straight Flush":
		case "Flush":
		case "Straight":
			return ranks[handRank] + " high " + p.getHandStrength();
		case "Full House":
			return p.getHandStrength() + " of " + ranks[handRank] + "s";
		case "Three of a Kind":
			return "Three " + ranks[handRank] + "s";
		case "Two Pair":
		case "Pair":
			return p.getHandStrength() + " of " + ranks[p.getHandStrengthNum()] + "s";
		default:
			return ranks[handRank] + " High Card";
		}
	}

	public static boolean checkRoyalFlush(Player p, Table t) {
		if (checkStraight(p, t) && checkFlush(p, t) && p.getHandStrengthNum() == 11) {
			p.setHandStrength(handStrengths[0]);
			return true;
		}
		return false;
	}

	public static boolean checkStraightFlush(Player p, Table t) {
		if (checkStraight(p, t) && checkFlush(p, t)) {
			p.setHandStrength(handStrengths[1]);
			return true;
		}
		return false;
	}

	public static ArrayList<Card[]> duplicates(Player p, Table t) {
		ArrayList<Card[]> pairs = new ArrayList<>();
		ArrayList<Card> allCards = new ArrayList<>();
		allCards.add(p.getHand()[0]);
		allCards.add(p.getHand()[1]);
		allCards.addAll(t.getBoard());
		for (int firstCard = 0; firstCard < allCards.size() - 1; firstCard++) {
			for (int secondCard = firstCard + 1; secondCard < allCards.size(); secondCard++) {
				if (allCards.get(firstCard).getRank() == allCards.get(secondCard).getRank()) {// "if there is a
					Card[] pair = { allCards.get(firstCard), allCards.get(secondCard) };
					pairs.add(pair); // pair"
					for (int thirdCard = secondCard + 1; thirdCard < allCards.size(); thirdCard++) {
						if (allCards.get(firstCard).getRank() == allCards.get(thirdCard)
								.getRank()) {/* "if there are three of a kind" */
							Card[] threeKind = { allCards.get(firstCard), allCards.get(secondCard),
									allCards.get(thirdCard) };
							removeRepeats(pairs, allCards.get(thirdCard).getRank());
							pairs.add(0, threeKind);
							if (thirdCard == pairs.size() - 1) {
								return pairs;
							}
							for (int fourthCard = thirdCard + 1; fourthCard < allCards
									.size(); fourthCard++) {/* "if there are four of a kind" */
								if (allCards.get(firstCard).getRank() == allCards.get(fourthCard).getRank()) {
									Card[] fourKind = { allCards.get(firstCard), allCards.get(secondCard),
											allCards.get(thirdCard), allCards.get(fourthCard) };
									removeRepeats(pairs, allCards.get(thirdCard).getRank());
									pairs.add(0, fourKind);
									return pairs;
								}
							} // end of fourth card loop
						}

					} // end of third card loop
				}
			} // end of second card loop
		} // end of first card loop
		return pairs;
	}// end of duplicates

	public static boolean checkFourOfaKind(Player p, ArrayList<Card[]> dups) {
		if (dups.size() > 0 && dups.get(0).length == 4) {
			p.setHandStrengthNum(dups.get(0)[0].getRank());
			p.setHandStrength("Four of a Kind");
			return true;
		}
		return false;
	}

	public static boolean checkFullHouse(Player p, ArrayList<Card[]> pairs) {
		if (pairs.size() == 0 || pairs.get(0).length < 3) {
			return false;
		}
		if (pairs.get(0).length == 3 && pairs.size() > 1) {
			p.setHandStrength("Full House");
			p.setHandStrengthNum(pairs.get(0)[0].getRank());
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkFlush(Player p, Table t) {
		int numSuit = 0;
		Card highCard = new Card(1, 0);
		for (int suit = 0; suit < suits.length; suit++) {// iterates through list of suits
			for (Card c : t.getBoard()) {// finds number of cards per each suit on the board
				if (c.getSuit() == suit) {
					numSuit++;
					if (highCard.getRank() == 0 || highCard.passedHasHigherRank(c, ranks)) {
						highCard.setRank(c.getRank());
						highCard.setSuit(suit);
					}
				}
			}
			for (Card c : p.getHand()) {// iterates through player's hand
				if (c.getSuit() == suit) {
					numSuit++;
					if (highCard.getRank() == 0 || highCard.passedHasHigherRank(c, ranks)) {
						highCard.setRank(c.getRank());
						highCard.setSuit(suit);
					}
				}
			}
			if (numSuit >= 5) {
				p.setHandStrength("Flush");
				int rank = ranks.length - 1;
				while (!(highCard.getRank() == rank)) {
					rank--;
				}
				p.setHandStrengthNum(rank);
				return true;
			}
			numSuit = 0;
		} // end of suits loop
		return false;
	}// end of checkflush

	public static boolean checkStraight(Player p, Table t) {
		int consecCount = 0;
		for (int leadCardRank = ranks.length - 1; leadCardRank >= 0; leadCardRank--) { // check for straight
			if (t.isInBoard(leadCardRank) || (p.getHand()[0].getRank() == leadCardRank)
					|| p.getHand()[1].getRank() == leadCardRank) {
				consecCount++;
			} else {
				consecCount = 0;

			}
			if (consecCount == 5) {// five ordered cards
				p.setHandStrength("Straight");
				p.setHandStrengthNum(leadCardRank + 4);
				return true;
			}
		} // end of for loop
		if ((consecCount == 4)
				&& (t.isInBoard(13) || p.getHand()[0].getRank() == 13 || p.getHand()[1].getRank() == 13)) {
			p.setHandStrength("Straight");
			p.setHandStrengthNum(4);
			return true;
		} else {
			return false;
		}
	}// end of checkStraight

	public static boolean checkThreeOfaKind(Player p, ArrayList<Card[]> dups) {

		if (dups.size() != 0 && dups.get(0).length == 3) {
			p.setHandStrength("Three of a Kind");
			p.setHandStrengthNum(dups.get(0)[0].getRank());
			return true;
		}
		return false;
	}

	public static boolean checkPairs(Player p, Table t) {

		if (duplicates(p, t).size() > 1 && duplicates(p, t).get(0).length == 2) {
			p.setHandStrength("Two Pair");
			p.setHandStrengthNum(duplicates(p, t).get(0)[0].getRank());
			return true;
		} else if (duplicates(p, t).size() == 1 && duplicates(p, t).get(0).length == 2) {
			p.setHandStrength("Pair");
			p.setHandStrengthNum(duplicates(p, t).get(duplicates(p, t).size() - 1)[0].getRank());
			return true;
		}
		return false;
	}

	public static ArrayList<Card[]> simplifyDups(Player p, ArrayList<Card[]> dups) {
		int highDupRank;
		if (dups.size() > 0 && dups.get(0).length > 2) {
			highDupRank = dups.get(0)[0].getRank();
			for (int i = dups.size() - 1; i > 0; i--) {
				if (dups.get(i)[0].getRank() == highDupRank) {
					dups.remove(i);
				}
			}
		}
		return dups;
	}

	public static int highRank(Player p, Table t) {
		Card highestCard = new Card();
		highestCard.setRank(t.getBoard().get(0).getRank());
		for (Card card : t.getBoard()) {
			if (highestCard.passedHasHigherRank(card, ranks)) {
				highestCard.setRank(card.getRank());
			}
		}
		if (highestCard.passedHasHigherRank(p.getHand()[0], ranks)) {
			highestCard.setRank(p.getHand()[0].getRank());
		} else if (highestCard.passedHasHigherRank(p.getHand()[1], ranks)) {
			highestCard.setRank(p.getHand()[1].getRank());
		}
		return highestCard.getRank();
	}// end of highRank

	// accessors(getters)
	public static int getAnte() {
		return ante;
	}

	public static ArrayList getHandStrengths() {
		ArrayList<String> hs = new ArrayList<>();
		for (String s : handStrengths) {
			hs.add(s);
		}
		return hs;
	}

	public static ArrayList getRanks() {
		ArrayList<String> rs = new ArrayList<>();
		for (String s : ranks) {
			rs.add(s);
		}
		return rs;
	}

	public static ArrayList getSuits() {
		ArrayList<String> ss = new ArrayList<>();
		for (String s : suits) {
			ss.add(s);
		}
		return ss;
	}

	public static ArrayList<Card> getUsedCards() {
		return usedCards;
	}

	// modifiers(setters)
	public static void setAnte(int ante) {
		HandInfo.ante = ante;
	}

	public static void removeRepeats(ArrayList<Card[]> pairs, int rank) {
		for (int i = pairs.size() - 1; i >= 0; i--) {
			if (rank == pairs.get(i)[0].getRank()) {
				pairs.remove(i);
			}
		}
	}

	public static ArrayList<Card> fullDeck() {
		ArrayList<Card> fullDeck = new ArrayList<>();
		for (int suit = 0; suit < suits.length; suit++) {
			for (int rank = 0; rank < ranks.length; rank++) {
				fullDeck.add(new Card(suit, rank));
			} // end of rank loop
		} // end of suit loop
		return fullDeck;
	}// end of fullDeck
}
