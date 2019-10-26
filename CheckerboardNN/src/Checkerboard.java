import java.awt.Color;

public class Checkerboard {

	// two-dimensional array that is the board
	private Color[] boardArr;

	// constructor-> randomly assigns colors to board
	public Checkerboard() {
		boardArr = new Color[4];
		for (int i = 0; i < boardArr.length; i++) {
			int randomVal = (int) (Math.random() * 2);
			if (randomVal == 0) {
				boardArr[i] = Color.white;
			} else {
				boardArr[i] = Color.black;
			}

		}
	}// end of constructor

	// getters
	public Color[] getBoard() {
		return boardArr;
	}

}
