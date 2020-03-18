package Java.src.main.java.xyz.wilzer.Spielautomat;

public class Kasse{

    private int Kapital;
    public Kasse(){
        Kapital = 0;
    }
    public void einzahlen(int pGeld){
        Kapital += pGeld;
    }

    public void auszahlen(int pGeld){
        Kapital -= pGeld;
    }

    public int getKapital(){
        return Kapital;
    }
}