import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse FeldErzeugen.
 * 
 * @author Lukas Langrock
 * @version 2020-05-26
 */
public class FeldErzeugen
{
    // Attribute
    int laenge;
    int[] zahlen;

    // Beziehungen
    Bubblesort bubblesortAlgorythm;
    Insertionsort insertionsortAlgorythm;
    Selectionsort selectionsortAlgorythm;

    /**
     * Konstruktor für Objekte der Klasse FeldErzeugen
     */
    public FeldErzeugen(int anzahlElemente)
    {
        laenge = anzahlElemente;
        zahlen = unSortiertesFeld();
    }

    public void sort(String algorythm)
    {
        switch (algorythm) {
            case "Bubblesort":
            bubblesortAlgorythm = new Bubblesort();
            zahlen = bubblesortAlgorythm.Entrypoint(zahlen);
            bubblesortAlgorythm = null;
            break;

            case "Insertionsort":
            insertionsortAlgorythm = new Insertionsort();
            zahlen = insertionsortAlgorythm.Entrypoint(zahlen);
            insertionsortAlgorythm = null;
            break;

            case "Selectionsort":
            selectionsortAlgorythm = new Selectionsort();
            zahlen = selectionsortAlgorythm.Entrypoint(zahlen);
            selectionsortAlgorythm = null;
            break;
        }
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
