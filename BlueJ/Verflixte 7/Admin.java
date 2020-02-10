import java.util.Scanner;

public class Admin
{
    private Player P1;
    private Player P2;
    private Die D1;
    private Die D2;
    private Pot Po;
    private Scanner scan;
    public Admin()
    {
       clearScreen();
        scan = new Scanner(System.in);
        System.out.println("Please enter Player " + 1 + "'s name!");
        String player1 = scan.nextLine();
        System.out.println("Please enter Player " + 2 + "'s name!");
        String player2 = scan.nextLine();
        Po = new Pot();
        D1 = new Die(6);
        D2 = new Die(6);
        P1 = new Player(player1, D1, D2, Po, this);
        P2 = new Player(player2, D1, D2, Po, this);
        startGame();
    }
    public static void clearScreen() {  
    System.out.print("\u000C");  
    System.out.flush();  
}  
    public void resetGame()
    {
            P1.setPoints(0);
            P2.setPoints(0);
    }
    public void endTurn(Player pP1, Player pP2)
    {
            if(pP2.getTurns() > 0)
                {
                    if (pP1.getPoints() > pP2.getPoints())
                    {
                        System.out.println(pP1.getName() + " won and received the current bet of " + Po.getBet());
                        pP1.setScore(Po.getBet() + pP1.getScore());
                        System.out.println(pP1.getName() + " has a score of " + pP1.getScore());
                        System.out.println(pP2.getName() + " has a score of " + pP2.getScore());
                        resetGame();
                        P1.setTurns(0);
                        P2.setTurns(0);
                        Po.setBet(0);
                        if (pP1.question("Would you like to continue playing?"))
                            startGame();
                        else
                            System.exit(0);
                    }
                    else if (pP1.getPoints() == pP2.getPoints())
                    {
                        System.out.println("It's a tie and nobody claims the bet");
                        System.out.println(pP1.getName() + " has a score of " + pP1.getScore());
                        System.out.println(pP2.getName() + " has a score of " + pP2.getScore());
                        resetGame();
                        if (pP1.question("Would you like to continue playing?"))
                            startGame();
                        else
                            System.exit(0);
                    }
                    else
                    {
                        System.out.println(pP2.getName() + " won and received the current bet of " + Po.getBet());
                        pP2.setScore(pP2.getScore() + Po.getBet());
                        System.out.println(pP1.getName() + " has a score of " + pP1.getScore());
                        System.out.println(pP2.getName() + " has a score of " + pP2.getScore());
                        resetGame();
                        P1.setTurns(0);
                        P2.setTurns(0);
                        Po.setBet(0);
                        if (pP2.question("Would you like to continue playing?"))
                            startGame();
                        else
                            System.exit(0);
                    }
                }
            else
                wannaDice(P2, P1);
            return;
    }
        /*
        else
        {
            System.out.println("Please place a bet first.");
            startTurn(pP1, pP2); 
        }
        */
    
    public void startGame()
    {
        clearScreen();
        System.out.println("Please place a Bet, " + P1.getName());
        int pBet = scan.nextInt();
        if(pBet > 0)
        P1.placeBet(pBet);
        else
        {
            System.out.println("Your bet must be a whole number and larger than zero (0)");
            startGame();
        }
        System.out.println("Please place a Bet, " + P2.getName());
        pBet = scan.nextInt();
        if(pBet > 0)
            P1.placeBet(pBet);
        else
        {
            System.out.println("Your bet must be a whole number and larger than zero (0)");
            startGame();
        }
        wannaDice(P1, P2);
    }
    public void wannaDice(Player pP1, Player pP2)
    {
            do
            {
                if(pP1 == P2)
                    if (pP1.question("Would you like to roll some dice, " + pP1.getName() + "?"))
                        pP1.throwDice();
                    else if(pP1.getTurns() <= 0)
                        System.out.println("You must throw the dice at least once, " + pP1.getName() + "!");
                    else
                        break;
                else
                    if (pP1.question("Would you like to roll some dice, " + pP1.getName() + "?"))
                    {
                        pP1.throwDice();
                        wannaDice(pP1,pP2);
                    }
                    else if(pP1.getTurns() <= 0)
                    {
                        System.out.println("You must throw the dice at least once, " + pP1.getName() + "!");
                        wannaDice(pP1,pP2);
                    }
                    else
                        break;
            }
            while(pP1.getTurns()<pP2.getTurns());
            endTurn(pP1, pP2);
    }
}