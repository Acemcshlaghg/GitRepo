
import java.util.ArrayList;

public class HandStrength {
	private static String handStrengthName;
	private static int neededOnTheBoard;
	private static double possibilityValue;
	private static ArrayList<ArrayList<ArrayList<Card>>> workingHands;
	private static ArrayList<ArrayList<ArrayList<Card>>> possibleHands;
	private boolean suitsMatter;
	private static Player player;
	private static Table table;

	public HandStrength() {
		this("High Card", 3, 0, new Player(), new Table());
	}

	public HandStrength(String handStrengthName, int neededAfterFlop, double possibilityValue, Player player,
			Table table) {
		this.handStrengthName = handStrengthName;
		this.neededOnTheBoard = neededAfterFlop;
		this.possibilityValue = possibilityValue;
		this.player = player;
		this.table = table;
		this.workingHands = new ArrayList<>();
	}

	// accessors
	public static String getHandStrengthName() {
		return handStrengthName;
	}

	public ArrayList<ArrayList<ArrayList<Card>>> getPossibleHands() {
		return workingHands;
	}

	public static Player getPlayer() {
		return player;
	}

	public Table getTable() {
		return table;

	}
	// modifiers

	public void setHandStrengthName(String handStrengthName) {
		this.handStrengthName = handStrengthName;
	}

	public void setPossibleHands(ArrayList<ArrayList<ArrayList<Card>>> possibleHands) {
		this.workingHands = possibleHands;
	}

	// methods
//	public boolean isPossible() {
//		for(int i )
//	}

	public static void addToWorkingHands(ArrayList<ArrayList<Card>> toAdd) {
		workingHands.add(toAdd);
	}

	public double probabilitySum() {
		double probablilitySum = 0;

		ArrayList<Card> handAndBoard = new ArrayList<>();
		handAndBoard.addAll(this.table.getBoard());
		handAndBoard.add(player.getHand()[0]);
		handAndBoard.add(player.getHand()[1]);

		if (!suitsMatter) {
			for (Card c : handAndBoard) {
				c.setSuit(0);
			}
		}

		for (int listOfHands = 0; listOfHands < workingHands.size(); listOfHands++) {
			for (int hand = 0; hand < workingHands.get(listOfHands).size(); hand++) {
				int cardsThisHandHas = 0;
				for (int card = 0; card < workingHands.get(listOfHands).get(hand).size(); card++) {
					if (!suitsMatter) {
						workingHands.get(listOfHands).get(hand).get(card).setSuit(0);
					}
					if (handAndBoard.indexOf(workingHands.get(listOfHands).get(hand).get(card)) >= 0) {
						cardsThisHandHas++;
					}
				}
				if (cardsThisHandHas == this.neededOnTheBoard) {
					probablilitySum += possibilityValue / ((52 - getTable().getBoard().size() - 4) * 1.0);
				} else if (cardsThisHandHas > this.neededOnTheBoard) {
					probablilitySum += possibilityValue / ((52 - getTable().getBoard().size() - 4) * 0.5);
				}
			}
		} // end of working hands loop
		return probablilitySum;
	}// end of probablilitySum

}
