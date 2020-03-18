package Java.src.main.java.xyz.wilzer.Misc.Bank;

public class Bank {
    public static void main(String args[]){
        new Bank();
    }

    //private String name;
    private Konto konto1;
    private Konto konto2;

    public Bank(){
        konto1 = new Konto(987654321);
        konto2 = new Konto(1234567890);
    }

    public void einzahlen(int kontonummer, double betrag){
        Konto konto = konto1;
        if (kontonummer == konto2.getKontonummer())
            konto = konto2;
        konto.einzahlen(betrag);
    }

    public void abheben(int kontonummer, double betrag){
        Konto konto = konto1;
        if (kontonummer == konto2.getKontonummer())
            konto = konto2;
        konto.abheben(betrag);
    }

    public void ueberweisen(int vonKontonummer, int nachKontonummer, double betrag){
        abheben(vonKontonummer, betrag);
        einzahlen(nachKontonummer, betrag);
    }

}