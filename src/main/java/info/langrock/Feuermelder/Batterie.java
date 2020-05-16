
/**
 * Beschreiben Sie hier die Klasse Batterie.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Batterie
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int ladestand;

    /**
     * Konstruktor für Objekte der Klasse Batterie.
     * @param newLadestand Ladestand der Batterie
     */
    public Batterie(int newLadestand)
    {
        // Instanzvariable initialisieren
        ladestand = newLadestand;
    }
    
    public int getLadestand()
    {
        return ladestand;
    }
    
    public void entleeren()
    {
        ladestand = 0;
    }
}
