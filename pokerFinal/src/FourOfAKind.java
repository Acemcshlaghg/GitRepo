import java.util.ArrayList;

public class FourOfAKind extends HandStrength {

	private static String handStrengthName = "Four of a Kind";

	public FourOfAKind(Player player, Table table) {
		super(handStrengthName, 2, 7, player, table);
		ArrayList<Integer> suits = HandInfo.getSuits();
		ArrayList<Integer> ranks = HandInfo.getRanks();
		ArrayList<ArrayList<Card>> insideWorkingHands = new ArrayList<>();
		ArrayList<Card> perRank = new ArrayList<>();
		for (int rank = 0; rank < ranks.size(); rank++) {
			for (int suit = 0; suit < suits.size(); suit++) {
				perRank.add(new Card(suits.get(suit), ranks.get(rank)));
			}
			insideWorkingHands.add(perRank);
		}
		addToWorkingHands(insideWorkingHands);

	}// end of constructor

}
