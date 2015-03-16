package certifDiceGame.certifDiceGame;

public class Player extends Thread {

	private String currentPlayer;
	private String otherPlayer;

	public Player (String name) {
		this.currentPlayer = name;
		this.otherPlayer = name.equals(Gamers.JOE) ? Gamers.JANE : Gamers.JOE;
	}

	@Override
	public void run () {
		
		for (int i = 0; i < 6; i ++) {
			
			synchronized (Dice.class) {
				while (!Dice.getTurn().equals(currentPlayer)) {
					try {
						Dice.class.wait(1000);
						System.out.println(currentPlayer + " was waiting for " + otherPlayer);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Dice.getTurn() + " throws " + Dice.roll());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Dice.setTurn(otherPlayer);
				Dice.class.notifyAll();
			}
		}

	}
}
