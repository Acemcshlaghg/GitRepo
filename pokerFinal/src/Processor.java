import java.awt.List;
import java.util.ArrayList;

public class Processor {// determines probability of success
	private Player player;
	private Table table;
	private ArrayList<Card> allCards = new ArrayList<>();
	private ArrayList<ArrayList> infoMatrix;
	private HandStrength royalFlush;
	private HandStrength straightFlush;
	private HandStrength fourOfAKind;

	
	public Processor() {
		this(new Player(), new Table());
	}

	public Processor(Player player, Table table) {
		this.player = player;
		this.table = table;

		// creates array of all cards:
		this.allCards.addAll(table.getBoard());
		this.allCards.add(player.getHand()[0]);
		this.allCards.add(player.getHand()[1]);
		this.royalFlush = new RoyalFlush(player, table);
		this.straightFlush = new StraightFlush(player, table);
		this.fourOfAKind = new FourOfAKind(player, table);

		// intantiates infoMatrix:

	}

	// accessors
	public Player getPlayer() {
		return player;
	}

	public Table getTable() {
		return table;
	}

	// modifiers
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	// brain methods
	public double percentSuccess() {
		double finalPercent = 0;
		Card[] currentHand = player.getHand();
		ArrayList<Card> board = table.getBoard();
		if (board.size() == 3) {
			finalPercent = cpuAfterFlopChances(board);
		}
		return finalPercent;
	}

	public double cpuAfterFlopChances(ArrayList<Card> board) {
		Player p = new Player();
		int handStrengthIndex = HandInfo.getHandStrengths().indexOf(player.getHandStrength());
		ArrayList<Card> cardsLeft = HandInfo.fullDeck();
		cardsLeft.removeAll(HandInfo.getUsedCards());
		double possibilitySum = 0;
		
		//iterates through hand strengths
		for (int strength = handStrengthIndex; strength < HandInfo.getHandStrengths().size(); strength++) {
			
		}
		return 1.1;
	}

	/*
	 * "Royal Flush"- 9 + 0(only one possibility) "Straight Flush"- 8 + (weight/9
	 * possibiliies) "Four of a Kind"- 7 + (weight/ 13 possibilites) "Full house"- 6
	 * + (weight of threeKind/13 possibilites) + (weight of pair/1200 possibilites)
	 * "Flush"- 5 + (weight / 8 possibilites) "Straight"- 4 + (weight/ 9
	 * possibilities) "Three of a Kind"- 3 + (weight/13 possibilities) "Two Pair"- 2
	 * + (weight/12 possibilities) "Pair"- 1 + (weight/13 possibilities)
	 * "High Card"- 0 + (weight/8 possibilities)
	 */
	
	public double sumOfProbablilities() {
		return royalFlush.probabilitySum() + straightFlush.probabilitySum() + fourOfAKind.probabilitySum();
		
	}
}
