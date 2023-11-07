import java.util.Scanner;
public class Sudoku {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Specify size of the (NxN) Board: ");
        
        int size = input.nextInt();
        int[][] board = new int[size][size];
        board = insertBoard(size);
        
        if(solve(board))
            print(board);
        else
            System.out.println("The board is not solvable...");

        input.close();
    }

    
    /** 
     * @param size
     * @return int[][]
     */
    public static int[][] insertBoard(int size){
        int[][] board = new int[size][size];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.println("Please enter row " + i + " column " + j + " number: ");
                board[i][j] = input.nextInt();
            }
        }
        input.close();
        return board;
    }

    
    /** 
     * @param board
     * @return boolean
     */
    public static boolean solve(int[][] board){
        boolean isEmpty = true;
        int row = 0, col = 0;

        outerloop:
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break outerloop;
                }
            }
        }

        // No Empty space left
        if(isEmpty)
            return true;

        for(int num = 1; num < board.length; num++){
            if(isValid(board, row, col, num)){
                board[row][col] = num;
                if(solve(board))
                    return true;
                else
                    board[row][col] = 0;
            }
        }

        return false;
    }

    
    /** 
     * @param board
     * @param row
     * @param col
     * @param num
     * @return boolean
     */
    public static boolean isValid(int[][] board, int row, int col, int num){
        for(int i = 0; i < board.length; i++)
            if(board[row][i] == num)
                return false;
        
        for(int i = 0; i < board.length; i++)
            if(board[i][col] == num)
                return false;

        return true;
    }

    
    /** 
     * @param board
     */
    public static void print(int[][] board){
        for (int i = 0; i < board.length; i++) { 
            for (int j = 0; j < board.length; j++) 
                System.out.print(board[i][j] + " "); 
            System.out.print("\n"); 
        }
    }
}
