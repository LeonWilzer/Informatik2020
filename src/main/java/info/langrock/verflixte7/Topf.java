
/**
 * Klasse Topf nach Beschreibung
 * 
 * @author David Tepaße
 * @version 01
 */

public class Topf
{
   /**
    *Attribut der Klasse Topf:
    */
   private int einsatz;

    /**
     * Konstruktor für Objekte der Klasse Topf:
     */
   public Topf()
   {
       // der Einsatz wird auf 0 gesetzt
       einsatz = 0;
   }

   /**
    *
    * Gibt die Summe, die im Topf liegt, zurück und leert den Topf.
    */
   public int einsatzAbgeben ()
   {
       int lastEinsatz = einsatz;
       einsatz = 0;
       return lastEinsatz;
   }

   /**
    * nimmt den einsatz auf
    */
   public void einsatzAufnehmen (int pEinsatz)
   {
        einsatz += pEinsatz;
   }

}

