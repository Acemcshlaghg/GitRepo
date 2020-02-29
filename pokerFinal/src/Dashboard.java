import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class Dashboard {
	private PrintWriter dataWriter;
	public Dashboard() {
		
		try {
			//
			dataWriter = new PrintWriter(new FileWriter("data.txt", true));
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void addHand(Table table, Player p1, Player cpu) {
		dataWriter.append("hand @" + System.currentTimeMillis() + "\n" +
				"P1 Hand: " + HandInfo.printHand(p1) + "\n" +
				"CPU Hand: " + HandInfo.printHand(cpu) + "\n" +
				"Board: " + table.getBoard() + "\n\n"
				
				);
	}

	public void close() {
		dataWriter.close();
	}

}
