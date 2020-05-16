//import java.util. *;

/**
 * Dice used get a random number between 1 and 6.
 * 
 * @author Lukas langrock
 * @version 2
 */

public class Dice
{
    private int value;

   /**
    * Initializes the dice
    */
   public Dice()
   {
       value = 0;
   }
   
   /**
    * Return the value of the rolled dice.
    * @return Eye count of the dice
    */
   public int getValue()
   {
      return value;
    }
   
   /**
    * Returns a random value
    * @return random value between 1 and the maximum
    */   
   private int getRandomValue(int maximum)
   { 
      int diceValue = 0;
      diceValue =(int)Math.round(Math.random()*(maximum-1))+1;
      return diceValue;
   }

   /**
    * Roll the dice
    */
   public void rollDice()
   {
      value = getRandomValue(6);
   }
}
