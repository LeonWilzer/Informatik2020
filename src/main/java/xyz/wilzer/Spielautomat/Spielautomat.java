package Java.src.main.java.xyz.wilzer.Spielautomat;

public class Spielautomat{

    public static void main(String args[]) {
        new Spielautomat();
    }
    
    private Rad[] Wheel = new Rad[3];
    private int points;
    private Kasse Bank;
    private Spieler Player;

    public Spielautomat(){
        Bank = new Kasse();
        Player = new Spieler();
        for(int i = 0; i<Wheel.length; i++){
            Wheel[i] = new Rad();
        }
        einwerfen();
        starten();
    }
    public void starten(){
       System.out.println("O  Fortuna!");
       System.out.println();
        points = 0;
        int tPoint = 0;
        for(int i = 0; i<3; i++){
            tPoint = Wheel[i].getZahl();
            System.out.println("Wheel "+ (i+1) +": " + tPoint);
            points += tPoint;
        }
        auszahlen(points);
    }

    public void einwerfen(){
        Player.einwerfen(30);
        Bank.einzahlen(30);

    }

    public void auszahlen(int pNum){
        if(pNum == 0){
            Bank.auszahlen(30);
            Player.einstecken(30);

            System.out.println("You just friggin' won mate!");
        }
        else{
            System.out.println("You just friggin' lost mate!");
        }
    }
}