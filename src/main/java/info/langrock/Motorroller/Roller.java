
/**
 * Die Klasse Roller ist das Fahrzeug, mit dem der Beistzer fahren kann.
 * 
 * @author Thomas Kempe
 * @version 1.0 vom 25.06.2014
 */
public class Roller
{
    //Anfang Attribute
    private double tankgroesse;
    private double tankinhalt;
    private int kilometerstand;
    //Ende Attribute

    /**
     * Der Konstruktor erzeugt ein Objekt der Klasse, wobei alle Attribute per Paramterübergabe initialisiert werden.
     * @param pTankgroesse Gibt des Startwert des Attributs tankgroesse an
     * @param pKmStand Gibt des Startwert des Attributs kilometerstand an
     * @param pTankinhalt Gibt des Startwert des Attributs tankinhalt an
     */
    public Roller(double pTankgroesse, int pKmStand, double pTankinhalt)
    {
        tankgroesse = pTankgroesse;
        kilometerstand = pKmStand;
        tankinhalt = pTankinhalt;
    }

    //Anfang Methoden
    /**
     * Die sondierende Methode für das Attribut kilometerstand.
     * @return Das Attribut kilometerstand wird zurückgegeben.
     */
    public int getKilometerstand (){
        return kilometerstand;
    }

    /**
     * Das Attribut tankinhalt wird erhöht, sofern die Menge in den Tank passt.
     * @param pMenge Um diesen Wert wird der Tankinhalt erhöht
     */
    public void tanke(double pMenge) {
        if (passtInTank(pMenge)) {
            tankinhalt = tankinhalt + pMenge;
        }
    }
   /**
     * Die sondierende Methode für das Attribut tankinhalt.
     * @return Das Attribut tankinhalt wird zurückgegeben.
     */
    public double getTankinhalt (){
        return tankinhalt;
    }
    /**
     * Der Roller fährt eine bestimmte Strecke, sofern genug Tankinhalt vorhanden ist. 
     * Der Roller verbraucht 0.03 Liter pro Kilometer.
     * @param pStrecke Die zu fahrende Strecke
     */
    public void fahre (int pStrecke) {
        double spritverbrauch = 0.03 * pStrecke;
        if (spritverbrauch <= tankinhalt) {
            kilometerstand = kilometerstand + pStrecke;
            tankinhalt = tankinhalt - spritverbrauch;
        }
    }
    /**
     * Die sondierende Methode für das Attribut tankgroesse.
     * @return Das Attribut tankgroesse wird zurückgegeben.
     */
    public double getTankgroesse (){
        return tankgroesse;
    }
    
    /**
     * Es wirg geprüft, ob die gewünschte Menge Sprit in den Tank passt.
     * @param pMenge Gibt die gewünschte zu tankende Menge an.
     * @return Gibt an, ob die gewünschte Menge getankt werden kann.
     */
    public boolean passtInTank(double pMenge) {
        if (tankgroesse >= tankinhalt + pMenge) {
            return true;
        } else {
            return false;
        }
    }
    //Ende Methoden
}//end of Roller
