package Java.src.main.java.xyz.wilzer.Nim;

public class Pot {
	private int sticks;
	private int chips;
	public Pot() {
		sticks = 0;
		chips = 0;
	}
	public int getChips(){
		return chips;
	}
	public void setChips(int pChips){
		chips = pChips;
	}
	public int getSticks(){
		return sticks;
	}
	public void setSticks(int pSticks){
		sticks = pSticks;
	}
}
