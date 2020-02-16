
public class CPUPlayer extends Player {
	// constructor
	public CPUPlayer() {
		super();
	}

	public CPUPlayer(Card[] cards, int chipStack, int bet) {
		super(cards, chipStack, bet);// calls Player's constructor
	}

	// decisions
	public void makeDecision(String handStage, String firstAction, int toCall) {
		if(handStage.equals("post flop") && firstAction.equals("cpu")) {
			firstActionPostFlop();
		}
		else if(handStage.equals("post flop") && firstAction.equals("player")) {
			secondActionPostFlop(toCall);
		}
		else if(handStage.equals("post turn") && firstAction.equals("cpu")) {
			firstActionPostFlop();
		}
		else if(handStage.equals("post turn") && firstAction.equals("player")) {
			secondActionPostFlop(toCall);
		}
		else if(handStage.equals("post river") && firstAction.equals("cpu")) {
			firstActionPostFlop();
		}
		else if(handStage.equals("post river") && firstAction.equals("player")) {
			secondActionPostFlop(toCall);
		}
	}
	public void firstActionPostFlop() {
		check();
	}

	public void secondActionPostFlop(int toCall) {

	}

	public void firstActionPostTurn() {

	}

	public void secondActionPostTurn(int toCall) {

	}

	public void firstActionPostRiver() {

	}

	public void secondActionPostRiver(int toCall) {

	}
}
