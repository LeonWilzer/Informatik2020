package nim;

public class Player {
	boolean valid;
	int chips;
	int ID;
	Pot Pot;
	Main Main;
	public Player(int id, Pot pot, Main main) {
		chips = 3;
		ID = id;
		Pot = pot;
		Main = main;
		valid = true;
	}
	public void doTurn(){
		if (Pot.getSticks()==0 && ID == 0)
		{
			System.out.println("You are the first player, please place 10 to 40 matches into the Box!");
			int input = nim.Main.Scan.nextInt();
			if (input <= 40 && input >= 10)
				Pot.setSticks(input);
		}
		if (Pot.getSticks()==1) {
			Pot.setSticks(0);
			//Main.removePlayer(ID);
		}
		take();
	}
	public void take(){
		System.out.println("Matches in the Box: " + Pot.getSticks());
		System.out.println("Please remove 1 to 3 matches, Player" + ID + ".");
		int input = nim.Main.Scan.nextInt();
		if (input <= 3 && input >= 1)
			Pot.setSticks(Pot.getSticks() - input);
	}
	public int getChips(){
		return chips;
	}
	public void setChips(int pChips){
		chips = pChips;
	}
	public boolean getValidation(){
		return valid;
	}
}