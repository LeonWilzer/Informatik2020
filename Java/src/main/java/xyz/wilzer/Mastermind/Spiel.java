package Java.src.main.java.xyz.wilzer.Mastermind;

import Java.src.main.java.xyz.wilzer.Common.Input;
import Java.src.main.java.xyz.wilzer.Common.Clear;

public class Spiel {
    public static void main(String args[]){
        new Spiel();
    }
    private int[] code = new int[4];
    private int[] tipp = new int[4];
    private int versuche;
    private int[]  highscore = new int[10];

    public Spiel(){
        for(int i=0;i<highscore.length;i++)
            highscore[i] = 0;
        while(true){
        neuesSpiel();
        erstelleCode();
        tippAbgeben();
        tippAnzeigen();
        speichernInHighscore();
        highscoreAnzeigen();
        }
    }

    public void neuesSpiel(){
        versuche = 0;
        for(int i=0;i<4;i++){
            code[i] = 0;
            tipp[i] = 0;
        }
    }

    public void erstelleCode(){
        int number;
        for(int i=0;i<code.length;i++){
            number = Input.getUserInt("Please provide an integer between 1 and 4 for your code! " + (i+1) + ". Number:");
            if  (0 < number && number < 5)
                code[i] = number;
            else{
                System.out.println("Please only provide integers between 1 and 4.");
                erstelleCode();
                break;
            }
        }
        Clear.clearScreen();
    }

    public void tippAbgeben(){
        int number;
        versuche++;
        for(int i=0;i<tipp.length;i++){
            number = Input.getUserInt("Please provide an integer between 1 and 4 for your guess! " + (i+1) + ". Number:");
            if  (0 < number && number < 5)
                tipp[i] = number;
            else{
                System.out.println("Please only provide integers between 1 and 4.");
                tippAbgeben();
                break;
            }
        }
        pruefeTipp();
    }

    public void tippAnzeigen(){
        System.out.println("Tipp:");
        for(int i=0;i<tipp.length;i++)
            System.out.println(tipp[i]);
    }

    public void pruefeTipp(){
        int correct = 0;
        for(int i=0;i<tipp.length;i++){
        System.out.println("Number " + (i+1) + " is:");
            if(tipp[i]==code[i]){
                System.out.println("Correct");
                correct++;
            }
            else
                System.out.println("Incorrect");
        }
        if (correct==tipp.length)
            System.out.println("Needed tries: " + versuche);
        else
            tippAbgeben();
    }

    public void speichernInHighscore(){
        for(int i=0;i<highscore.length;i++){
            if (highscore[i]==0){
                highscore[i]=versuche;
                break;
            }
        }

    }

    public void highscoreAnzeigen(){
        System.out.println("Highscores:");
        for(int i=0;i<highscore.length;i++)
            System.out.println(highscore[i]);
    }

    public int minimumHighscore(){
        int min = 0;
        for(int i=0;i<highscore.length;i++){
            if(highscore[i] < min)
                min = highscore[i];
        }
        return min;
    }

    public int maximumHighscore(){
        int max = 0;
        for(int i=0;i<highscore.length;i++){
            if(highscore[i] > max)
                max = highscore[i];
        }
        return max;
    }

}