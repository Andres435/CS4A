/**
 * Quintana, Andres
 * 09/03/2020
 * Student ID: 1074306
 * 
 * This program calculates the monthly mortgage payment for a home loan along with the 
 * total amount of interest paid over the life of the loan.
 */
import java.util.Scanner;

public class Mortagage {
    public static void main(String[] word){
        Scanner input = new Scanner (System.in);
        int loan = 0;

        //repeats until user input 0 in loan
        outerloop:
        do{
            System.out.print("Please enter a positive integer for the loan amount: ");
            // Repeats until user enter positive value
            do{
                loan = input.nextInt();
                if (loan < 0)
                    System.out.print("RETRY: Please enter a positive integer for the loan amount: ");
                else if (loan == 0)
                    break outerloop;
            } while(loan < 0);
            
            double rate = 0;
            System.out.print("Please enter a positive number for the annual interest rate: ");
            // Repeats until user enter positive value
            do{
                rate = input.nextDouble();
                if (rate < 0)
                    System.out.print("RETRY: Please enter a positive number for the annual interest rate: ");
            } while(rate < 0.0);
    
            int years = 0;
            System.out.print("Please enter a positive integer for the term in years: ");
            // Repeats until user enter positive value
            do{
                years = input.nextInt();
                if (years < 0)
                    System.out.print("RETRY: Please enter a positive integer for the term in years: ");
            } while(years < 0);
    
            System.out.println("\nFor a loan with these characteristics: ");
            System.out.println("\t $ " + loan);
            System.out.printf("\t %.2f annual interest rate \n", rate);
            System.out.println("\t " + years + " year term\n");
            
            // Monthly Interest rate
            double c = ((rate / 12 ) / 100);
            // Year term in months
            int n = years * 12;
            // Calculate monthly payments
            double formula = ((loan * (c * (Math.pow((1 + c), n)))) / (Math.pow((1 + c), n) - 1));
            // Total amount paid
            double paid = formula * n;
            // Interets paid
            double interest = paid - loan;

            System.out.printf("The Monthly Payment = $%.2f \n", formula);
            System.out.printf("The Total Amount Paid = $%.2f  \n", paid);
            System.out.printf("The Total Interest Paid = $%.2f  \n\n\n", interest);
        } while (loan != 0);

        System.out.println("THANK YOU FOR USING THE MORTGAGE CALCULATOR!!\n");
        input.close();
    }
}