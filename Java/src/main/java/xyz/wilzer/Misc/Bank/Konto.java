
public class Konto{
    private int kontonummer;
    private String kontoinhaber;
    private double guthaben;
    public Konto(int pKontonummer){

    }

    public int getKontonummer(){
        return kontonummer;
    }
    public void setKontonummer(int pKontonummer){
        kontonummer = pKontonummer;
    }
    public String getKontoinhaber(){
        return kontoinhaber;
    }
    public void setKontoinhaber(String pKontoinhaber){
        kontoinhaber = pKontoinhaber;
    }
    public double getGuthaben(){
        return guthaben;
    }
    public void setGuthaben(double pGuthaben){
        guthaben = pGuthaben;
    }

    public void einzahlen(double betrag){
        guthaben += betrag;
    }
    
    public void abheben(double betrag){
        guthaben -= betrag;
    }
    
    public void druckeKontauszug(){

    }

}