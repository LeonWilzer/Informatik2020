/**
 * Der Besitzer eines Rollers kann diesen fahren und ihn betanken, sofern er genug Geld hat.
 * 
 * @author Thomas Kempe
 * @version 1.0 vom 25.04.2014
 */
public class Besitzer
{
    // Attribute
    private String name;
    private double geld;
    private Roller meinRoller;

    //Anfang Methoden

    /**
     * Der Konstruktor erzeugt ein Objekt der Klasse, wobei alle Attribute per Parameterübergabe initialisiert werden.
     * @param pName gibt den Startwert des Attributs name an.
     * @param pGeld Gibt den Startwert des Attributs geld an.
     * @param pRoller Ein Objekt der Klasse Roller wird als meinRoller referenziert.
     */
    public Besitzer(String pName, double pGeld, Roller pRoller)
    {
        name = pName;
        geld = pGeld;
        meinRoller = pRoller;
    }

    /**
     * Die sondierende Methode für das Attribut name
     * @return Das Attribut name wird zurückgegeben.
     */
    public String getName() { 
        return name;
    }

    /**
     * Die sondierende Methode für das Attribut name
     * @return Das Attribut geld wird zurückgegeben.
     */
    public double getGeld() { 
        return geld;
    }

    /**
     * Der Tankinhalt des Objekts meinRoller wird erhöht und das Geld wird (der Einfachheit halber) um pMenge reduziert.
     * @param pMenge Die zu tankende Menge
     */
    public void tankeDeinenRoller (double pMenge) {
        if (pMenge *1.5 <= geld) {
            meinRoller.tanke(pMenge);
            geld = geld - (pMenge*1.5);
        }
    }

    /**
     * Der Kilometerstand des Objekts meinRoller wird erhöht.
     * @param pStrecke Gibt die zu fahrende Strecke an.
     */
    public void fahreDeinenRoller (int pStrecke) {
        meinRoller.fahre(pStrecke);
    }

    /**
     * Das Geld des Besitzers wird erhöht.
     * @param pSumme Der Wert, um den geld erhöht wird.
     */
    public void erhalteTaschengeld(double pSumme) {
        geld = geld + pSumme;
    }
}
