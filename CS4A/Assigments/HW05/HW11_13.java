/*
    Program that prompts the user to enter 10 integers to a list and displays
    the distinct integers separated by exactly one space.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class HW11_13 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        System.out.print("Enter 10 integers: ");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) 
            list.add(input.nextInt());

        removeDuplicate(list);
        System.out.print("Distict integer are: ");
        System.out.print(list);

        input.close();
    }

    
    /** 
     * @param list
     */
    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
            if (!temp.contains(list.get(i)))
                temp.add(list.get(i));
        
        list.clear();
        list.addAll(temp);
    }
}
