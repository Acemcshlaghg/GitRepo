import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Dashboard {
	private FileWriter fstream;
	private PrintWriter data;

	public Dashboard() {

		try {
			//
			fstream = new FileWriter("data.txt", true);
			data = new PrintWriter(fstream);
			data.append(System.currentTimeMillis() + " Stuff");
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void addTable(Table table) {
		data.append("new");
	}

	public void close() {
		data.close();
	}

}
