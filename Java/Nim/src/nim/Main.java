package nim;
import java.util.Scanner;

/**
 * @author leon
 *
 */

public class Main {
	
	public static void main(String args[]) {	
		new Main();
	}
	private Pot Pot;
	public static Scanner Scan;
	private Main Main;
	private Player p1;
	private Player p2;	
	public Main(){
		Scan = new Scanner(System.in);
		Pot = new Pot();
		Main = this;
		p1 = new Player(1, Pot, Main);
		p2 = new Player(2, Pot, Main);
		if(doGame() == p1)
			System.out.println("Player 1 won the game!");
		else
			System.out.println("Player 2 won the game!");
		
	}
	
	public static int howMuch(String pString) {
		System.out.println(pString);
		int ans;
		try {
			ans = Scan.nextInt();
			return ans;
		}
		catch (NumberFormatException e) {
			return howMuch(pString);
		}
	}
	
	public Player first(Player player) {
		
			System.out.println("Both players pay 1 chip");
				Pot.setChips(Pot.getChips() + 2);
				p1.setChips(p1.getChips() -1);
				p2.setChips(p2.getChips() -1);
			System.out.println(Pot.getChips() + " Chips are in the box.");
			System.out.println("Player 1 has "+ p1.getChips());
			System.out.println("Player 2 has "+ p2.getChips());

		return player.doTurn();
	}
	
	public Player doGame() {
		Player loser;
		while(true){
			if(p2.getChips() == 0 || p1.getChips() == 0)
				break;
			loser = first(p1);
			if(loser == p1){
				p2.setChips(Pot.getChips() + p2.getChips());
			}
			else{
				p1.setChips(Pot.getChips() + p1.getChips());
			}
			Pot.setChips(0);
		
			if(p2.getChips() == 0 || p1.getChips() == 0)
				break;
			loser = first(p2);
			if(loser == p1)
				p2.setChips(Pot.getChips() + p2.getChips());
			else
				p1.setChips(Pot.getChips() + p1.getChips());
			Pot.setChips(0);
	}
		if(p1.getChips() == 0)
			return p2;
		else
			return p1;
	}

	public Player getP1(){
		return p1;
	}
	public Player getP2(){
		return p2;
	}
}