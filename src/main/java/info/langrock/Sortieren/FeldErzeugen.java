import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse FeldErzeugen.
 * 
 * @author Michael Dohmen
 * @version 1.0
 */
public class FeldErzeugen
{
    // Attribute
    int laenge;
    int[] zahlen;

    // Beziehungen

    /**
     * Konstruktor für Objekte der Klasse FeldErzeugen
     */
    public FeldErzeugen(int anzahlElemente)
    {
        
        laenge= anzahlElemente;
    }
    /**
     * Hier wird ein sortiertes Feld erzeugt. Es gibt keine gleichen Zahlen
     * @return sortiertes Zahlenfeld
     */
    public int[] sortiertesFeld()
    {
        Random r = new Random();
        zahlen= new int[laenge];
        zahlen[0]=r.nextInt(4);

        for (int i=1; i<laenge; i++)
        {
            zahlen[i]=zahlen[i-1]+r.nextInt(5)+1;
        }
        return zahlen;
    }
     /**
     * Hier wird ein unsortiertes Feld erzeugt. Es kann gleiche Zahlen geben
     * @return unsortiertes Zahlenfeld
     */
    public int[] unSortiertesFeld()
    {
        Random r = new Random();
        zahlen= new int[laenge];
        for (int i=0; i<laenge; i++)
        {
            zahlen[i]=r.nextInt(5*laenge);
        }
        return zahlen;
    }
}
