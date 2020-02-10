import java.util.Random;
/**
 * Write a description of class Die here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Die
{
    // instance variables - replace the example below with your own
    private int sides;

    /**
     * Constructor for objects of class Die
     */
    public Die(int psides)
    {
        sides = psides;
    }

    public int roll()
    {
        Random random = new Random();
        return random.nextInt(sides+1);
    }
}