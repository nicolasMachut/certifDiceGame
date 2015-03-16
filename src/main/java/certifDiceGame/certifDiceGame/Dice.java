package certifDiceGame.certifDiceGame;
import java.util.Random;

public class Dice {

	private static String turn;
	private static Random random = new Random();
	
	private Dice () {
		
	}
	
	synchronized public static String getTurn () {
		return turn;
	}
	
	synchronized public static void setTurn (String name) {
		turn = name;
	}
	
	public static void setWhoStart (String name) {
		turn = name;
	}
	
	public static int roll () {
		return random.nextInt(6) + 1;
	}
	
	
}
