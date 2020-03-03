package Java.src.main.java.xyz.wilzer.Common.Games.Dice;

import java.util.Random;

public class Dice{

    public static int roll(int range){
        Random Rand = new Random();
        return Rand.nextInt(range);
    }
}