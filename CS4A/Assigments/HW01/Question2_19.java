/**
 * The program prompts the user to enter three points of a triangle and displays its area.
 */
import java.util.Scanner;

public class Question2_19 {
    
    /** 
     * @param word
     */
    public static void main(String[] word){
        Scanner input = new Scanner (System.in);

        System.out.println("Enter 3 points:");

        System.out.print("Enter (x) component for the first point: ");
        double x_1 = input.nextDouble();
        System.out.print("Enter (y) component for the first point: ");
        double y_1 = input.nextDouble();

        System.out.print("Enter (x) component for the second point: ");
        double x_2 = input.nextDouble();
        System.out.print("Enter (y) component for the second point: ");
        double y_2 = input.nextDouble();

        System.out.print("Enter (x) component for the third point: ");
        double x_3 = input.nextDouble();
        System.out.print("Enter (y) component for the third point: ");
        double y_3 = input.nextDouble();

        double side_1 = Math.sqrt(Math.pow((x_2 - x_1), 2) + Math.pow(y_2 - y_1, 2));
        double side_2 = Math.sqrt(Math.pow((x_3 - x_2), 2) + Math.pow(y_3 - y_2, 2));
        double side_3 = Math.sqrt(Math.pow((x_1 - x_3), 2) + Math.pow(y_1 - y_3, 2));

        double surface = (side_1 + side_2 + side_3) / 2;
        double area = Math.sqrt(surface * (surface - side_1) * (surface - side_2) * (surface - side_3));

        System.out.println("The area of the triangle is " + area);
        
        input.close();
    }
}