package Java.src.main.java.xyz.wilzer.Misc.diceAutomata;

import Java.src.main.java.xyz.wilzer.Common.Dice;

public class Main {

    int d1;
    int d2;
    int pasch;
    int seven;
    public static void main(String args[]) {
        new Main();
    }

    public Main(){
        d1 = 0;
        d2 = 0;
        pasch = 0;
        seven = 0;
        System.out.println("1x:");
        System.out.println(conclude());
        System.out.println(pasch);
        System.out.println(seven);
        d1 = 0;
        d2 = 0;
        pasch = 0;
        seven = 0;
        System.out.println("500x:");
        System.out.println(concludeX(500));
        System.out.println(pasch);
        System.out.println(seven);
    }

    public void rollDice(){
        d1 = Dice.roll(6)+1;
        d2 = Dice.roll(6)+1;
    }
    public int conclude(){
        rollDice();
        if (d1 + d2 == 7 )
            seven++;
        else if(d1 == d2)
            pasch++;
        return d1 + d2;
    }
    public int concludeX(int pNum){
        int sum = 0;
        for(int i = 0; i<pNum; i++){
            sum += conclude();
        }
        return sum;
    }    
}