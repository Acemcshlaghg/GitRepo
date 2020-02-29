import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pokerMain extends JFrame {
	// instance variables
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// initialize hand
		Player p1 = new Player();
		CPUPlayer cpu = new CPUPlayer();
		Table t = new Table();
		Dashboard d = new Dashboard();
		GraphicsMain window = new GraphicsMain();
			JPanel p = new JPanel();
			p.add(new GraphicsPanel());
			window.setTitle("PokerFinal");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setContentPane(p);
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);	
//		for (int hands = 0; hands < 5; hands++) {// hand loop beginning

			Card[] p1Hand = { HandInfo.dealCard(), HandInfo.dealCard() };
			Card[] cpuHand = { HandInfo.dealCard(), HandInfo.dealCard() };
			p1.setHand(p1Hand);
			cpu.setHand(cpuHand);
			// pre-flop
			// Takes ante from each player
			p1.setChipStack(p1.getChipStack() - HandInfo.getAnte());
			cpu.setChipStack(cpu.getChipStack() - HandInfo.getAnte());
			//print ante and chipstack
//			System.out.println("Ante: $" + HandInfo.getAnte());
//			System.out.print("You have $");
//			System.out.printf(Locale.US, "%,d %n \n", p1.getChipStack());
//			System.out.printf("%s %s %n %n", "Your Hand:" + HandInfo.printHand(p1),
//					"CPU Hand:" + HandInfo.printHand(cpu));

			// Deals cards
			//For now doing all at once
			System.out.print("Board: ");
			for (int i = 0; i < 5; i++) {// random board, adds to and displays board
				Card c = HandInfo.dealCard();
				t.getBoard().add(c);
				System.out.print(t.getBoard().get(i));
			}
			
			d.addHand(t, p1, cpu);
			System.out.println("\n \n" + "Your Hand Strength: " + HandInfo.handStrength(p1, t));
			System.out.print("CPU Hand Strength: " + HandInfo.handStrength(cpu, t) + "\n \n");
			// end of hand
			
//		} // end of hand loop
		
		d.close();// closes writer
	}// end of main method

	public static void action(String firstAction, String handStage, int betPlaced, Player p1) {
		int moveChoice;
		if (betPlaced == 0) {
//			System.out.println("Choose your Action:");
//			System.out.println("1. Check");
//			System.out.println("2. Bet");
			moveChoice = 2;
			switch (moveChoice) {
			case 1:
				p1.check();
				break;
			case 2:
				p1.bet();
				break;
			default:
				System.out.println("invalid entry");
			}
		} else {
			System.out.println("Choose your move:");
			System.out.println("1. Call $" + betPlaced);
			System.out.println("2. Raise");
			System.out.println("3. Fold");
		}

	}

	/*
	 * high card possibilities:
	 *
	 */
}
