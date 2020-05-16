
/**
 * ALARM!
 * 
 * @author Lukas Langrock 
 * @version 12.02.2020
 */
public class Feuermelder
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private double laustaerke;
    private boolean alarm;
    private Batterie eingelegteBatterie;

    /**
     * Konstruktor für Objekte der Klasse Feuermelder.
     * @param newLaustaerke Laustaerke des Feuermelders
     * @param newAlarm Alarmzustand des Feuermelders
     * @param newEingelegteBatterie Die in den feuermelder eeingelegte Batterie
     */
    public Feuermelder(double newLaustaerke, boolean newAlarm, Batterie newEingelegteBatterie)
    {
        // Instanzvariable initialisieren
        laustaerke = newLaustaerke;
        alarm = newAlarm;
        eingelegteBatterie = newEingelegteBatterie;
    }
    
    /**
     * Gibt die Laustaerke an.
     * @return laustaerke variable
     */
    public double getLaustearke()
    {
        return laustaerke;
    }
    
    /**
     * Gibt den Alarm-Status an.
     * @return alarm variable
     */
    public boolean getAlarm()
    {
        return alarm;
    }
    
    public Batterie getBatterie()
    {
        return eingelegteBatterie;
    }
    
    /**
     * Meldet ein Feuer und schaltet den Alarm an.
     */
    public void feuerMelden()
    {
        alarm = true;
        eingelegteBatterie.entleeren();
    } 
    
    /**
     * Schaltet den Alarm aus.
     */
    public void alarmAbschalten()
    {
        alarm = false;
    }
}
