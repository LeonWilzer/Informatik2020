
/**
 * Beschreiben Sie hier die Klasse Engine.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Engine
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int stage;
    private boolean takeInput;
    private String userInput;
    private Jackpot activeJackpot;
    private Player activePlayer;
    private Player[] allPlayer;

    /**
     * Konstruktor für Objekte der Klasse Engine.
     */
    public Engine(String[] playerNames)
    {
        Announce("Initilizing components...");
        /* Initilizing vars */
        takeInput = false;
        userInput = null;
        stage = 0;
        
        /* Create new objects */
        activeJackpot = new Jackpot();
        allPlayer = new Player[playerNames.length];
        
        for (int i=0; i<playerNames.length; i++)
        {
            allPlayer[i] = new Player(playerNames[i], activeJackpot);
        }
        
        Announce("Processing rules...");
        activePlayer = allPlayer[0];
        
        Announce("Ready!");
        Announce("Run the Action() method to proceed to the next game stage.");
    }
    
    /**
     * Overloading handler of Announce()
     */
    public void Announce(String message)
    {
        Announce("Engine", message);
    }
    
    /**
     * Engine announcer for console messages.
     * @param prefix Prefix to place in brackets in final message
     * @param message Body of the message
     */
    public void Announce(String prefix, String message)
    {
        System.out.print("[" + prefix.toUpperCase() + "] " + message + "\n");
    }
    
    /**
     * Checks if the current Player
     */
    public boolean CheckPlayerMaximum()
    {
        if (activePlayer == allPlayer[allPlayer.length]) { return true; }
        else { return false; }
    }
    
    /**
     * Publicly executed function which keeps track of the game progress
     * and runs other logic functions.
     */
    public void Action()
    {
        switch(stage){
            case 0: Announce("Initialization failed! Please restart the application.");
                    break;
            case 1: StageSetJackpot();
                    break;
        }
    }
    
    /**
     * Publicly executed function which takes a players input
     * as requsted by Action().
     */
    public void Input(String input)
    {
        if (takeInput)
        {
            takeInput = false;
            userInput = input;
            Announce("Input", "Input saved. Please run Action again.");
        }
        else
        {
            Announce("Input", "There is no need to input any data.");
        }
    }
    
    private void StageSetJackpot()
    {
        
        Announce("Player " + activePlayer.getName() + ", please run Input() and enter your Jackpot intake.");
        takeInput = true;
    }
}
