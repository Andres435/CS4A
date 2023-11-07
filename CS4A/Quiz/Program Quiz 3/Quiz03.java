/**
 * Quintana, Andres
 * 09/10/2020
 * Student ID: 1074306
 * 
 *  This program that calculates the day of the week (Sunday – Saturday) 
 *  for any date enter in a MM DD YYYY format.The program will run 
 *  indefinitely until a 0 input is received.
 */
import java.util.Scanner;

public class Quiz03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Day Of Week calculator. This awesome" + 
                        " program will tell you what day of the week you were" + 
                        " born on!\nThe program will allow you to find the day of" + 
                        " the week for multiple dates. When you want exit the" + 
                        " program enter a 0 for the month, day, or year.");
    int day = 0;
    int month = 0;
    int year = 0;

    outerloop:
    do{
        System.out.println("\nEnter a date in MM DD YYYY format (example: 11 1 1970 or 6 21 2011):");
        month = input.nextInt();
        day = input.nextInt();
        year = input.nextInt();

        // Check if user want to exit the program
        // Otheriwise, calculate the day of the week
        if (check(day, month, year))
            break outerloop;
        else
            calculate(day, month, year);
    } while(!(check(day, month, year)));

    System.out.println("\nTHANK YOU FOR USING THE DAY OF WEEK CALCULATOR\n");
    input.close();
  }
  // Check if user input 0, if so return true, otherwise false
  public static boolean check (int day, int month, int year){
    if(day == 0 || month == 0 || year == 0)
        return true;
    else 
        return false;
  }

  // Calculate the day of the week based on the inputs day, month and year
  public static void calculate(int day, int month, int year){
    int [] num = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    
    // Algorithm that finds the week day for the date input
    year -= (month < 3) ? 1 : 0;
    int weekDay = (year + year/4 - year/100 + year/400 + num[month - 1] + (day - 1)) % 7;

    System.out.print("The date you entered was a ");
    switch (weekDay){
        case 0: System.out.print("Monday\n"); break;
        case 1: System.out.print("Tuesday\n"); break;
        case 2: System.out.print("Wednesday\n"); break;
        case 3: System.out.print("Thursday\n"); break;
        case 4: System.out.print("Friday\n"); break;
        case 5: System.out.print("Saturday\n"); break;
        case 6: System.out.print("Sunday\n"); break;
    }
  }
}