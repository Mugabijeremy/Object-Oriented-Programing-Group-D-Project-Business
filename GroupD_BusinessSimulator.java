
import java.util.Scanner;


public class GroupD_BusinessSimulator{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int paracetamolQty; int coughSyrupQty; int bandagesQty;  int vitaminsQty;
        // Prices
        double paracetamolPrice = 1500;
        double coughSyrupPrice = 6000;
        double bandagesPrice = 2500;
        double vitaminsPrice = 20000;

        //user input
        System.out.print("Enter number of Paracetamol packs: ");
        paracetamolQty = sc.nextInt();

        System.out.print("Enter number of Cough Syrup: ");
        coughSyrupQty = sc.nextInt();

        System.out.print("Enter number of Bandages: ");
        bandagesQty = sc.nextInt();

        System.out.print("Enter number of Vitamins: ");
        vitaminsQty = sc.nextInt();
    }
}