/**
 * This is a program display the population for a specific year. 
 */
import java.util.Scanner;

public class Question2_11 {
    
    /** 
     * @param word
     */
    public static void main(String[] word){
        // A day in seconds is 86400
        int yearsInSeconds = (86400 * 365);
        int birth = yearsInSeconds / 7;
        int death = yearsInSeconds / 13;
        int immigrant = yearsInSeconds / 45;
        int population = 312_032_486;

        Scanner input = new Scanner (System.in);
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        for(int i = 0 ; i < years; i++){
            population += ((birth - death) + immigrant);
        }

        System.out.println("Population of the " + years + " year: " + population);
        input.close();
    }
}