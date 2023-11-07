/**
 * Quintana, Andres
 * 10/09/2020
 * Student ID: 1074306
 * 
 *  The program determine if each of the territoriescan be colored using a different color 
 *  so that no two neighboring territoriesare colored with the same color.
 */
public class MidTerm {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        String[] availableColors = {"RED", "GREEN", "BLUE"};
        boolean neighbors[][] = {{false, true, true, true}, 
                                 {true, false, true, false}, 
                                 {true, true, false, true}, 
                                 {true, false, true, false}}; 
        //Get territory colors
        int[] territoryColors = generateColorMap(availableColors, neighbors);
        
        if (territoryColors != null)
            displaySolution(availableColors, territoryColors);
        else
            System.out.println("No solution exists");
    }

    
    /** 
     * @param availableColors
     * @param boolean[][]neighbors
     * @return int[]
     */
    //This function calls the recursion function
    public static int[] generateColorMap(String[] availableColors, boolean[][]neighbors){
        int[] colorMap = new int[neighbors.length];

        // Calls Helper(The recursion function)
        if(generateColorMapHelper(availableColors.length - 1, neighbors, colorMap, 0))
            return colorMap;
        else 
            return null;
    }

    
    /** 
     * @param numColors
     * @param neighbors
     * @param colorMap
     * @param index
     * @return boolean
     */
    // This function solves the coloring problem by using backtracking recursion
    public static boolean generateColorMapHelper(int numColors, boolean[][] neighbors, int[] colorMap, int index){
        // Check if index reached the end
        if(index == neighbors.length){
            //Check if they are neighbors
            if(isValid(neighbors, colorMap))
                return true;
            else
                return false;
        }

        // Recursive backtracking
        for(int i = 0; i <= numColors; i++){
            colorMap[index] = i;
            if(generateColorMapHelper(numColors, neighbors, colorMap, index + 1))
                return true;
            colorMap[index] = 0;
        }

        return false;
    }

    
    /** 
     * @param neighbors
     * @param colorMap
     * @return boolean
     */
    //  checks if territories are neighbors
    public static boolean isValid(boolean[][] neighbors, int[] colorMap){
        for(int i = 0; i < neighbors.length; i++)
            for(int j = i + 1; j < neighbors.length; j++)
                if(neighbors[i][j] && colorMap[i] == colorMap[j])
                    return false;
        
        return true;
    }

    
    /** 
     * @param allColors
     * @param territoryColors
     */
    //Print the each territory color
    public static void displaySolution(String[] allColors, int[] territoryColors){
        for(int i = 0; i < territoryColors.length; i++)
            System.out.println("Territory " + i + " = " + allColors[territoryColors[i]]);
    }
}
