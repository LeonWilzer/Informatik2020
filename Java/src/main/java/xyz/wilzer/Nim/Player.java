package main.java.xyz.wilzer.Nim;

import java.util.InputMismatchException;

public class Player {
	int chips;
	int ID;
	Pot Pot;
	Main Main;
	public Player(int id, Pot pot, Main main) {
		chips = 3;
		ID = id;
		Pot = pot;
		Main = main;
	}
	public Player doTurn(){
		try{
		if (Pot.getSticks()==0)
		{	
				System.out.println("Player " + ID + ", you are the first player, please place 10 to 40 matches into the Box!");
			int input = nim.Main.Scan.nextInt();
			if (input <= 40 && input >= 10)
				Pot.setSticks(input);
			else
				return doTurn();
		}
		else if (Pot.getSticks() > 1 && Pot.getSticks() < 4){
			Pot.setSticks(1);
		}
		else if (Pot.getSticks()==1) {
			Pot.setSticks(0);
			System.out.println("Player " + ID + " lost this round!");
			return this;
		}
		else
			take();
		if (ID == 1)
			return Main.getP2().doTurn();
		else
			return Main.getP1().doTurn();
	}
	public void take(){
		try{
		System.out.println("Matches in the Box: " + Pot.getSticks());
		System.out.println("Please remove 1 to 3 matches, Player" + ID + ".");
		int input = nim.Main.Scan.nextInt();
		if (input <= 3 && input >= 1)
			Pot.setSticks(Pot.getSticks() - input);
		else
			take();
		}
		catch (Exception e){
			System.out.println("Input must be an integer!");
			take();
		}
	}
	public int getChips(){
		return chips;
	}
	public void setChips(int pChips){
		chips = pChips;
	}
}