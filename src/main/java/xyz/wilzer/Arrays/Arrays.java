import java.util.Random;
public class Arrays
{
    private int[] six;
    private int[] wuerfel;
    private Random rand;
    public static void main(String[] args){
        new Arrays();
    }

    public Arrays(){
        six = new int[6];
        wuerfel = new int[30];
        rand = new Random();
        A1b();
        A1cd();
        System.out.println(sum());
        System.out.println(average());
    }

    public void A1b(){
        for (int i=0; i<six.length; i++){
            six[i] = i+1;
        }
    }

    public void A1cd(){
        for (int i=0; i<wuerfel.length; i++){
            wuerfel[i] = rand.nextInt(6) + 1;
            System.out.println(i + 1 +". Throw: " + wuerfel[i]);
        }
    }

    public int sum(){
        int sum = 0;
        for (int i=0; i<wuerfel.length; i++){
            sum += wuerfel[i];
        }
        return sum;
    }

    public double average(){
        return sum()/wuerfel.length;
    }
}