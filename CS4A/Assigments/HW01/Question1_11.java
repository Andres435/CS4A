/**
 * This is a program display the population for each of the next five years. 
 */
public class Question1_11{
    
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

        for(int i = 1; i < 6; i++){
            population += ((birth - death) + immigrant);
            System.out.println("Population of the " + i + " year: " + population);
        }
    }
}