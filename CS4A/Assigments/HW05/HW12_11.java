/*
    Write a program that removes all the occurrences of a specified 
    string from a text file.
*/
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class HW12_11 {
  
  /** 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Usage: java HW12_11 John test.txt");
      System.exit(1);
    }

    File file = new File(args[1]);
    if (!file.exists()) {
      System.out.println("No file " + args[1] + " was found.");
      System.exit(2);
    }

    String s = "";
    try (Scanner input = new Scanner(file);) {
      while (input.hasNext()) {
        s += input.nextLine() + "\n";
      }
      s = s.replaceAll(args[0], "");
    }

    try (PrintWriter output = new PrintWriter(file);) {
      output.print(s);
    }
  }
}
