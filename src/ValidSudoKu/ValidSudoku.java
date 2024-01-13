package ValidSudoKu;

import java.util.*;

public class ValidSudoku
{
    public ValidSudoku()
    {
        char[][] board = new char[9][9];
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board)
    {
        int matrixSize = 9;
        Set<Character> rowSet = null;
        List<Set<Character>> colSet = new ArrayList<>();
        List<List<Set<Character>>> subBoxSet = new ArrayList<>();

        for(int i=0; i<matrixSize; ++i)
            colSet.add(new HashSet<>());

        for(int i=0; i<matrixSize/3; ++i)
        {
            subBoxSet.add(new ArrayList<>());
            for(int j=0; j<matrixSize/3; ++j)
                subBoxSet.get(i).add(new HashSet<>());
        }

        for(int row = 0; row < matrixSize; ++row)
        {
            rowSet = new HashSet<>();
            for(int col = 0; col < matrixSize; ++col)
            {
                if(board[row][col] == '.') continue;
                if(rowSet.contains(board[row][col])) return false; //row
                if(colSet.get(col).contains(board[row][col])) return false; // col
                if(subBoxSet.get(row/3).get(col/3).contains(board[row][col])) return false; // subBox
                rowSet.add(board[row][col]);
                colSet.get(col).add(board[row][col]);
                subBoxSet.get(row/3).get(col/3).add(board[row][col]);
            }
        }

        return true;
    }
}
