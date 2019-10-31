import java.awt.Canvas;
public class MultiplesOf3and5 {
	public static void multiplesOf3and5(int num) {
		for (var i = 0; i <= Math.floor(num / 3); i++) {
			System.out.println(i * 3);
		}
		for (int i = 0; i <= Math.floor(num / 5); i++) {
			System.out.println(i * 5);
		}
	}
}
