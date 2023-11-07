/**
 *  Program that finds Permutations of a String
 */
import java.util.Scanner;

public class Question18_25{
    
	/** 
	 * @param word
	 */
	public static void main(String[] word){
        Scanner input = new Scanner (System.in);

        System.out.print("Enter String: ");
        String s = input.nextLine();

		displayPermutation(s);

        input.close();
    }

    
	/** 
	 * @param s
	 */
	// Recursive function to generate all permutations of a String
    public static void displayPermutation(String s){
        displayPermutation("", s);
    }

    
	/** 
	 * @param candidate
	 * @param remaining
	 */
	// Helper Method
	public static void displayPermutation(String candidate, String remaining)
	{
		if (remaining.length() == 0)
			System.out.println(candidate);

		for (int i = 0; i < remaining.length(); i++){
			String newCandidate = candidate + remaining.charAt(i);
			String newRemaining = remaining.substring(0, i) +
								  remaining.substring(i + 1);
			displayPermutation(newCandidate, newRemaining);
		}
	}
}
