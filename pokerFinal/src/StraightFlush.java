
import java.util.ArrayList;

public class StraightFlush extends HandStrength {

	private static String handStrengthName = "Straight Flush";


	public StraightFlush(Player player, Table table) {
		super(handStrengthName, 3, 8, player, table);
		ArrayList<String> suits = HandInfo.getSuits();
		ArrayList<String> ranks = HandInfo.getRanks();
		for (int suit = 0; suit < suits.size(); suit++) {
			ArrayList<ArrayList<Card>> sameSuit = new ArrayList<>();
			for (int startingRank = 0; startingRank <= 7; startingRank++) {
				ArrayList<Card> straights = new ArrayList<>();
				for (int rank = startingRank; rank < startingRank + 4; rank++) {
					straights.add(new Card(suits.get(suit), ranks.get(rank)));
				}
				sameSuit.add(straights);
			}
			addToWorkingHands(sameSuit);
		}

	}//end of constructor
	
	
}
