/*
    Program that converts the Java source code from the next-line brace
    style to the end-of-line brace style.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HW12_12 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        if (args.length != 1) {
            System.out.println("Invalid argument.");
            System.out.println("Usage: java HW12_12 test.txt");
            System.exit(1);
        }

        File filename = new File(args[0]);
        if (!filename.exists()) {
            System.out.println(filename + " does not exist.");
            System.exit(2);
        }

        StringBuilder buffer = new StringBuilder();
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                String s = input.nextLine();

                if (s.contains("{")) {
                    buffer.append(" {");
                } else {
                    buffer.append("\n" + s );
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            PrintWriter output = new PrintWriter(filename);
            output.write(buffer.toString());
            output.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(buffer);
    }

    
    /** 
     * @param s
     * @param ch
     * @return int
     */
    public static int getIndex(String s, char ch) {

        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
