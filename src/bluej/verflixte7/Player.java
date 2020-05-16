import java.util.Scanner;

/**
 * 
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int score;
    private String name;
    private int points;
    private Die D1;
    private Die D2;
    private Pot Po;
    private Admin Ad;
    private int turns;
    private Scanner scan;
    /**
     * Constructor for objects of class Player
     */
    public Player (String pname, Die pD1, Die pD2, Pot pP, Admin pAd)
    {
        scan = new Scanner(System.in); 
        score = 0;
        name = pname;
        points = 0;
        D1 = pD1;
        D2 = pD2;
        Po = pP;
        turns = 0;
        Ad = pAd;
    }
    public String getName()
    {
        return name;
    }
    public int getTurns()
    {
        return turns;
    }
    public int getPoints()
    {
        return points;
    }
    public void setTurns(int pturn)
    {
        turns = pturn;
    }
    public void setPoints(int pPoints)
    {
        points = pPoints;
    }
        /*
    public void startTurn()
    {    
        System.out.println("Please add a Bet, " + name);
        int pBet = scan.nextInt();
        if(pBet > 0)
            placeBet(pBet);
        else
            System.out.println("Your bet must be a whole number and larger than zero (0)");
        if (question("Would you like to roll some dice?"))
            throwDice();
        else if (turns <= 0)
            System.out.println("You must throw the dice at least once!");
        else
            endTurn();
    }
    */
    public boolean question(String text)
    {
        System.out.println(text);
        System.out.println("(Y)es/(N)o:");
        String i = scan.nextLine();
        switch(i)
        {
        case "N":
            return false;
        case "No":
            return false;
        case "n":
            return false;
        case "no":
            return false;
        case "Y":
            return true;
        case "Yes":
            return true;
        case "y":
            return true;
        case "yes":
            return true;
        default:
            return question(text);
        }
    }
        /*
    public void endTurn()
    {
        if(placedbet == true)
        {
        if(Pl.getTurns() > 0)
            {
                if (points > Pl.getPoints())
                {
                    System.out.println(this.name + " won and received the current bet of " + Po.getBet());
                    score =+ Po.getBet();
                    Po.setBet(0);
                }
                else if (points == Pl.getPoints())
                {
                    System.out.println("It's a tie and nobody claims the bet");
                }
                else
                {
                    System.out.println(Pl.name + " won and received the current bet of " + Po.getBet());
                    Pl.setScore(Pl.score + Po.getBet());
                    Po.setBet(0);
                }
            }
        placedbet = false;
        turns = 0;
        Pl.setTurns(0);
        Pl.setPlacedBet(false);
        }
        else
        System.out.println("Please place a bet first");
    }
    */
    public void throwDice()
    {
        turns++;
        int p = D1.roll() + D2.roll();
        if(p==7)
            points -= p;
        else
            points += p;
        System.out.println(points);
    }
    public void setScore(int pScore)
    {
        score = pScore;
    }
    public int getScore()
    {
        return score;
    }
    public void placeBet(int pbet)
    {
        if(pbet>0)
        {
            Po.setBet(Po.getBet()+pbet);
        }
    }
}
