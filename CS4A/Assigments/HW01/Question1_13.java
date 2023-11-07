/**
 * Program that solve 2 x 2 linear equations using Cramer's rule
 */
import java.util.Scanner;

public class Question1_13 {
    
    /** 
     * @param word
     */
    public static void main(String[] word){
        Scanner input = new Scanner (System.in);

        System.out.println("First Linear Equation:");

        System.out.print("Enter weigth for (x): ");
        float weigthA = input.nextFloat();
        System.out.print("Enter weigth for (y): ");
        float weigthB = input.nextFloat();
        System.out.print("Enter value assign for the linear equation: ");
        float valueE = input.nextFloat();

        System.out.println("Second Linear Equation:");
        
        System.out.print("Enter weigth for (x): ");
        float weigthC = input.nextFloat();
        System.out.print("Enter weigth for (y): ");
        float weigthD = input.nextFloat();
        System.out.print("Enter value assign for the linear equation: ");
        float valueF = input.nextFloat();

        float solvingX = ((valueE * weigthD) - (weigthB * valueF)) / ((weigthA * weigthD) - (weigthB * weigthC));
        float solvingY = ((valueF * weigthA) - (weigthC * valueE)) / ((weigthA * weigthD) - (weigthB * weigthC));

        System.out.println("Value of (x): " + solvingX);
        System.out.println("Value of (y): " + solvingY);

        input.close();
    }
}