/**
 * Klasse Spieler mit Fehlern
 * 
 * @author David Straße
 * @version 01
 * 
 * in dieser Klasse ist ein Fehler. Sie stimmt nicht mit
 * der Beschreibung unseres Spiels überein! Finden und korrigieren sie ihn.
 * 
 */

 
public class Player
{
   private Dice dice1;
   private Dice dice2;
   private Jackpot jackpot;
    
   private String name;
   private int points;
   private int wallet;
   private int rollCount;
   private boolean ready;
    
   /**
   * Konstruktor für Objekte der Klasse Spieler
   * Es werden automatisch alle benötigten Objekte erzeugt.
   */
   public Player(String pName, Jackpot pJackpot)
   {
       dice1 = new Dice();
       dice2 = new Dice();
       jackpot = pJackpot;
       name = pName;
       ready = false;
       System.out.print("[INFO] Player '" + name + "' initialized.\n");
   }
   
   public String getName() { return name; }
   public int getPoints() { return points; }
   public int getWallet() { return wallet; }
   public int getRollCount() { return rollCount; }
   public boolean getPermission() { return ready; }
   
   public void putMoney(int money)
   {
       jackpot.set(money);
       wallet -= money;
       System.out.print("[WARN] " + money + " points have been removed from Player '" + name +"'s wallet.\n");
       ready = true;
       System.out.print("[WARN] Player '" + name + "' has been granted permission to intercat with dices.\n");
   }
   
   public int rollDice(Dice pDice)
   {
       pDice.rollDice();
       return pDice.getValue();
   }

   public void rollDices()
   {
       if (ready)
       {
           rollCount++;
           int dice1_points = rollDice(dice1);
           int dice2_points = rollDice(dice2);
           int allDice_points = dice1_points + dice2_points;
           
           if (allDice_points == 7)
           {
               ready = false;
               System.out.print("[WARN] Player '" + name + "'s permission to intercat with dices has been revoked.\n");
               points -= 7;
           }
           else
           {
               points += allDice_points;
           }
        }
        else
        {
            System.out.print("[WARN] Operation not permitted!  Player's permission to interact with dices is revoked.\n");
        }
   }
   
   public void exit()
   {
       ready = false;
       System.out.print("[WARN] Player '" + name + "'s permission to intercat with dices has been revoked.\n");
   }
   
   public void win()
   {
       int jackpot_points = jackpot.win();
       wallet += jackpot_points;
       System.out.print("[WARN] " + jackpot_points + " points have been added to Player '" + name +"'s wallet.\n");
   }
   
   public void reset()
   {
       points = 0;
       rollCount = 0;
       ready = false;
       System.out.print("[WARN] Player '" + name + "' has been reset.\n");
   }
}

