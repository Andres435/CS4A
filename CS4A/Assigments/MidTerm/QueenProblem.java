public class QueenProblem {
    static final int SIZE = 4;
    static int count = 0;
    
    /** 
     * @param word
     */
    public static void main(String[] word) {
        char[][] board = new char[SIZE][SIZE];
        if(!(solve(board, 0)))
            System.out.println("Solution does not exist");
    }

    
    /** 
     * @param board
     * @param col
     * @return boolean
     */
    public static boolean solve(char[][] board, int col){
        if(col == board.length){
            print(board);
            return true;
        }
        
        boolean valid = false;;
        for(int i = 0; i < board.length; i++){
            if(queck(board, i, col)){
                board[i][col] = 'Q';
                valid = solve(board, col + 1) || valid;

                board[i][col] = ' ';
            }
        }
        return valid;
    }

    
    /** 
     * @param board
     * @param row
     * @param col
     * @return boolean
     */
    public static boolean queck(char[][] board, int row, int col){
        for(int i = 0; i < col; i++)
            if(board[row][i] == 'Q')
                return false;

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q')
                return false;

        for(int i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if(board[i][j] == 'Q')
                return false;

        return true;
    }

    
    /** 
     * @param board
     */
    public static void print(char[][] board){ 
        for (int i = 0; i < board.length; i++)  {  
            for (int j = 0; j < board.length; j++)  
                System.out.print(" " + board[i][j]);  
            
            System.out.print("\n");  
        }  
        System.out.print("\n");  
    }    
}
