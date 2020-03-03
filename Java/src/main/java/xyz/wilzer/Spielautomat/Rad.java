package Java.src.main.java.xyz.wilzer.Spielautomat;

import Java.src.main.java.xyz.wilzer.Common.Games.Dice.Dice;

public class Rad {
    int zahl;
    int anzahlZahlen;

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