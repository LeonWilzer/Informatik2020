/**
 * Jackpot used for holding and giving out money.
 * 
 * @author Lukas Langrock
 * @version 2
 */

public class Jackpot
{
   private int money;

    /**
     * Constructor for Jackpot.
     */
   public Jackpot()
   {
       money = 0;
   }

   /**
    * Let player win all money in Jackpot and clear the Jackpot afterwards.
    * @return Total money in the Jackpot
    */
   public int win()
   {
       int lastState = money;
       money = 0;
       return lastState;
   }

   /**
    * Let players move money to Jackpot
    * @param pMoney Money to put into Jackpot
    */
   public void set(int pMoney)
   {
        money += pMoney;
   }
}
