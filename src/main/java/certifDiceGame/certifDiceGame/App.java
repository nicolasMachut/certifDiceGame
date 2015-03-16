package certifDiceGame.certifDiceGame;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final Object lock = new Object();
	
    public static void main( String[] args )
    {
    	Player player1 = new Player(Gamers.JANE);
    	Player player2 = new Player(Gamers.JOE);
    	
    	Dice.setWhoStart(Gamers.JOE);
    	
    	player1.start();
    	player2.start();
    }
}
