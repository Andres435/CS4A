package sample;

/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

    private TicTacToe tictactoe = TicTacToe.getInstance();

    public boolean equalsZero()
    {
        int[][] replicant = tictactoe.getBoard();
        int count = 0;
        for(int i = 0; i < 3; ++i)
        {
            for(int j = 0; j < 3; ++j)
            {
                if(replicant[i][j] == 0)
                    ++count;
            }
        }
        return count == 9;
    }

    public boolean compareArray(int[][] arr1, int[][] arr2)
    {
        for(int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    void clearBoardTest()
    {
        tictactoe.clearBoard();
        Assertions.assertTrue(equalsZero());
    }

    @org.junit.jupiter.api.Test
    void checkUpHorizontalWin()
    {
        tictactoe.checkBox(0,0,true);
        tictactoe.checkBox(0,1,true);
        tictactoe.checkBox(0,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkMiddleUpHorizontalWin()
    {
        tictactoe.checkBox(1,0,true);
        tictactoe.checkBox(1,1,true);
        tictactoe.checkBox(1,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkDownHorizontalWin()
    {
        tictactoe.checkBox(2,0,true);
        tictactoe.checkBox(2,1,true);
        tictactoe.checkBox(2,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkLeftVerticalWin()
    {
        tictactoe.checkBox(0,0,true);
        tictactoe.checkBox(1,0,true);
        tictactoe.checkBox(2,0,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkMiddleVerticalWin()
    {
        tictactoe.checkBox(0,1,true);
        tictactoe.checkBox(1,1,true);
        tictactoe.checkBox(2,1,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkRightVerticalWin()
    {
        tictactoe.checkBox(0,2,true);
        tictactoe.checkBox(1,2,true);
        tictactoe.checkBox(2,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkLeftToRightWin()
    {
        tictactoe.checkBox(0,0,true);
        tictactoe.checkBox(1,1,true);
        tictactoe.checkBox(2,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkXWin()
    {
        tictactoe.checkBox(0,0,true);
        tictactoe.checkBox(1,0,true);
        tictactoe.checkBox(2,0,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }

    @org.junit.jupiter.api.Test
    void checkXWin2()
    {
        tictactoe.checkBox(2,0,true);
        tictactoe.checkBox(1,1,true);
        tictactoe.checkBox(0,2,true);
        Assertions.assertEquals(10, tictactoe.checkWin());
    }
}
*/
