package Java.src.main.java.xyz.wilzer.Spielautomat;

public class Spieler{
    private int vermoegen;
    public Spieler(){
        vermoegen = 0;
    }
    public void einwerfen(int pGeld){
        vermoegen -= pGeld;
    }

    public void einstecken(int pGeld){
        vermoegen += pGeld;
    }

    public int getVermoegen(){
        return vermoegen;
    }
}