
/**
 * Beschreiben Sie hier die Klasse Dice.
 * 
 * @author Lukas Langrock
 * @version 16-05-2020
 */
public class Dice
{
    public int diceValues[];
    
    /**
     * Constructs a dice object with the results of each throw.
     * @param count Number of throws to perform
     */
    public Dice(int count)
    {
        diceValues = new int [count];
        
        for (int i = 0; i < diceValues.length; i++)
        {
            diceValues[i] = Throw();
            int actual_dice = i + 1;
            System.out.println("Dice " + actual_dice + " shows the number " + diceValues[i] + ".");
        }
        
        System.out.println("All dices together sum up to " + SumUp() + ".");
        System.out.println("The average of all dices is " + SumAvg() + ".");
    }
    
    /**
     * Generates a random integer between 1 and 6.
     */
    private int Throw()
    {
        double random_double = Math.random() * 5 + 1;
        int random_int = Math.round((float)random_double);
        
        return random_int;
    }
    
    /**
     * Calculates the sum of the entire array.
     */
    private int SumUp()
    {
        int result = 0;
        
        for (int i = 0; i < diceValues.length; i++)
        {
            result += diceValues[i];
        }
        
        return result;
    }
    
    /**
     * Calculates the average of the entire array.
     */
    private int SumAvg()
    {
        int result = 0;
        int lenght = diceValues.length + 1;
        
        for (int i = 0; i < diceValues.length; i++)
        {
            result += diceValues[i];
        }
        
        result = result / lenght;
        
        return result;
    }
}
