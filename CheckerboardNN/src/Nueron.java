import java.awt.Color;
import java.awt.Point;

//Project : CheckerboardNN
public class Nueron {
//	instance variables-> set to null
	private Color colorIn = null;
	private Nueron[] input;
	private double value;
	private Point point;

//	for input neurons
	public Nueron(Color colorIn) {
		this.colorIn = colorIn;
		if (colorIn.equals(Color.black)) {
			value = 1;
		}

		else {
			value = 0;
		}
	}

//	for hidden and output neurons
	public Nueron(Nueron n1, Nueron n2) {
		this.input = new Nueron[2];
		this.input[0] = n1;
		this.input[1] = n2;
		this.input[0] = n1;
		double sum = n1.getValue() + n2.getValue();
		this.value = sum / 2.0;
	}

	public Nueron(Nueron n1, Nueron n2, Nueron n3) {
		this.input = new Nueron[3];
		this.input[0] = n1;
		this.input[1] = n2;
		this.input[2] = n3;
		double sum = n1.getValue() + n2.getValue() + n3.getValue();
		this.value = sum / 3.0;
	}

	// Accessors
	public double getValue() {
		return value;
	}

	public Point getPoint() {
		return point;
	}

	public Nueron[] getInput() {
		return input;
		
	}
	// Modifiers
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public void setInput(Nueron[] input) {
		this.input = input;
	}
}
