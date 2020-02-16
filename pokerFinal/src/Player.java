import java.util.Scanner;

public class Player {
	Scanner s = new Scanner(System.in);
	// instance variables
	private Card[] hand;
	private int chipStack;
	private int bet;
	private String handStrength;
	private int handStrengthNum = 20;
	private Card[] bestFiveCards;

	// constructors
	public Player() {
		this(new Card[2], 10000, 0);
	}

	public Player(Card[] cards, int chipStack, int bet) {
		this.hand = cards;
		this.chipStack = chipStack;
		this.bet = bet;
		this.handStrength = "High Card";
	}

	// accessors(getters)
	public Card[] getHand() {
		return hand;
	}

	public int getChipStack() {
		return chipStack;
	}

	public int getBet() {
		return bet;
	}

	public String getHandStrength() {
		return handStrength;
	}

	public int getHandStrengthNum() {
		return handStrengthNum;
	}

	public Card[] getBestFiveCards() {
		return bestFiveCards;
	}

	// modifiers(setters)
	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	public void setChipStack(int chipStack) {
		this.chipStack = chipStack;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public void setHandStrength(String handStrength) {
		this.handStrength = handStrength;
	}

	public void setHandStrengthNum(int hangStrengthNum) {
		this.handStrengthNum = hangStrengthNum;
	}

	public void setBestFiveCards(Card[] bestFiveCards) {
		this.bestFiveCards = bestFiveCards;
	}

	// Actions
	public void allIn() {
		System.out.println("went All In for $" + this.chipStack);
		this.bet = this.chipStack;
		this.chipStack = 0;
	}

	public void bet() {
		System.out.println("Enter bet amount: ");
		int bet = 100;
		if (bet >= chipStack) {
			allIn();
		} else {
			System.out.println("Bet $" + bet);
			this.chipStack -= bet;
			this.bet = bet;
		}
	}

	public void check() {
		System.out.println("Check");
		this.bet = 0;
	}

}
