/**
 * Klasse Spieler mit Fehlern
 * 
 * @author David Tepaße
 * @version 01
 * 
 * in dieser Klasse ist ein Fehler. Sie stimmt nicht mit
 * der Beschreibung unseres Spiels überein! Finden und korrigieren sie ihn.
 * 
 */

 
public class Spieler  
{
 /**
  * Eine Person kennt zwei Würfel und den Topf:
  */ 
 
   private   Wuerfel wuerfel1;
   private   Wuerfel wuerfel2;
   private   Topf topf;
   
  /** 
  * Hier folgen die Attribute der Klasse Person:
  */
  
   private String name;
   private int punkte;
   private int vermoegen;
   private int wurfAnzahl;
   private boolean ready;

   /**
    * Konstruktor für Objekte der Klasse Spieler
    * Mit der folgenden Methode wird ein Objekt der Klasse Spieler hergestellt.
    *
    public Spieler(Wuerfel pWuerfel1, Wuerfel pWuerfel2, Topf pTopf)
    {
        wuerfel1 = pWuerfel1;
        wuerfel2 = pWuerfel2;
        topf = pTopf;
    }
    */
    
    /**
    * Konstruktor für Objekte der Klasse Spieler
    * Es werden automatisch alle benötigten Objekte erzeugt.
    */
    public Spieler(String pName, Topf pTopf)
    {
        wuerfel1 = new Wuerfel();
        wuerfel2 = new Wuerfel();
        topf = pTopf;
        name = pName;
        ready = false;
        
        System.out.print("[Engine] Spieler '" + name + "' initialisiert.\n");
    }
    
   /**
    * Die bis dahin erreichte Punktesumme wird zurückgegeben.
    * @return Erreichte Punktzahl
    */
   public int punktestandAngeben ()
   {
       return this.punkte;
   }


   /**
    * (Hier fehlen die Kommentare. Das ist Ihre Aufgabe:.........)
    */
   public void topfLeeren ()
   {
        this.vermoegen = this.vermoegen + this.topf.einsatzAbgeben();
        this.punkte = 0;
        this.wurfAnzahl = 0;
   }

   /**
    * 
    */
   public int wurfAnzahlAngeben (Wuerfel pWuerfel)
   {
      return pWuerfel.punktzahlAngeben();
   }

   /**
    * 
    */
   public void einsatzSetzen (int einsatz)
   {
      topf.einsatzAufnehmen(einsatz);
      vermoegen -= einsatz;
      ready = true;
      System.out.print("[Engine] Spieler '" + name + "' hat " + einsatz + " Punkte in den Topf getan.\n");
   }

   public void wuerfeln ()
   {
       if (ready)
       {
         wuerfel1.rollen();
         wuerfel2.rollen();
         wurfAnzahl++;
         int wuerfel1_punkte = wurfAnzahlAngeben(wuerfel1);
         int wuerfel2_punkte = wurfAnzahlAngeben(wuerfel2);
         int wuerfelGesamt_punkte = wuerfel1_punkte + wuerfel2_punkte;
         
         if (wuerfelGesamt_punkte == 7)
         {
             punkte -= 7;
             System.out.print("[" + name + "] Eine 7! Zug beendet. Punkte: " + punkte + ".\n");
         }
         else
         {
             punkte += wuerfelGesamt_punkte;
             System.out.print("[" + name + "] Du hast eine " + wuerfel1_punkte + " und eine " + wuerfel2_punkte + ". Insgesamt hast du " + punkte + " Punkte.\n");
         }
       }
       else
       {
           System.out.print("[Engine] Du musst zuerst einen Einsatz machen!\n");
       }
   }
    
   public void zugBeenden()
   {
       System.out.print("[" + name + "] Zug beendet. Du hast jetzt " + punkte + " Punkte.\n");
   }
   
   public void gewinnen()
   {
       int topfInhalt = topf.einsatzAbgeben();
       vermoegen += topfInhalt;
       System.out.print("\n[Engine] Spieler '" + name + "' hat die Runde gewonnen und " + topfInhalt + " Punkte aus dem Topf erhalten. Er hat jetzt " + vermoegen + " Punkte.\n\n");
   }
   
   public void reset()
   {
       punkte = 0;
       wurfAnzahl = 0;
       ready = false;
       System.out.print("[Engine] Spieler '" + name + "' wurde zurückgesetzt.\n");
   }
}

