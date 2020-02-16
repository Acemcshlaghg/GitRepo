import java.util.ArrayList;

public class RoyalFlush extends HandStrength {
	private static String handStrengthName = "Royal Flush";

	public RoyalFlush(Player player, Table table) {
		super(handStrengthName, 3, 9, player, table);
		ArrayList<String> suits = HandInfo.getSuits();
		ArrayList<String> ranks = HandInfo.getRanks();
		ArrayList<ArrayList<Card>> insideWorkingHands = new ArrayList<>();
		for (int suit = 0; suit < suits.size(); suit++) {
			ArrayList<Card> current = new ArrayList<>();
			for (int rank = 8; rank < ranks.size(); rank++) {
				current.add(new Card(suits.get(suit), ranks.get(rank)));
			}
			if(current.size() > 0) {
			insideWorkingHands.add(current);
			}
		}
		if (insideWorkingHands.size() > 0) {
			addToWorkingHands(insideWorkingHands);
		}
	}

}
