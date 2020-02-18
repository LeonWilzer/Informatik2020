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
	Player[] Players;
	
	public Main(){
		Scan = new Scanner(System.in);
		Pot = new Pot();
		Main = this;
		Player[] Players = new Player[10];
		for(int i = 0; i<Players.length; i++) {
			Players[i] = new Player(i, Pot, Main);
			System.out.println(Players[i]);
		}
		doGame(0);
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
	
	public void first() {

		if(Players[0] != null)
			System.out.println("yes");
		else
			System.out.println("no");
		//System.out.println(Players.length);
		//System.out.println(Players[0]);

		for(int i = 0; i<Players.length;i++) {
			System.out.println("You are the first player, please place 10 to 40 matches into the Box!");
			if(Players[i] != null){
				Players[i].getValidation();
				Pot.setChips(Pot.getChips() + 1);
				Players[i].setChips(Players[i].getChips() -1);
			}
		}
		Players[0].doTurn();
	}
	
	public Player doGame(int ID) {
		first();
		int count = 0;
		while(count >= 1) {
			count = 0;
			for(int i = 0; i<Players.length && Players[i].getValidation();i++){
					count++;
					Players[i].doTurn();
				}
		}
		for(int i = 0; i<Players.length;i++) {
			if(Players[i].getValidation())
				return Players[i];
		}
		return null;
	}
	/*
	public void removePlayer(int ID) {5
		Players[ID] = null;
	}
	*/
}