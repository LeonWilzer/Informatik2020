package Java.src.main.java.xyz.wilzer.Spielautomat;

import Java.src.main.java.xyz.wilzer.Common.Dice;

public class Rad {
    private int zahl;
    private int anzahlZahlen;

    public Rad(){
      anzahlZahlen = 10;
    }
    public void drehen(){
      zahl = Dice.roll(anzahlZahlen);
    }

    public int getZahl(){
      drehen();
		  return zahl;
    }
}