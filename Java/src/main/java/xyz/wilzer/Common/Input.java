package Java.src.main.java.xyz.wilzer.Common;

import java.util.Scanner;

public class Input{
    public static int getUserInt(String question){
        Scanner scan = new Scanner(System.in);
        System.out.println(question);
        try{
            return scan.nextInt(); 
        }
        catch(Exception InputMismatchException){
            return getUserInt(question);
        }
    }
}