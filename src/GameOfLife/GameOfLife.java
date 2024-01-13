package GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife
{
    public GameOfLife()
    {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }

    public void gameOfLife(int[][] board)
    {
        int m = board.length;
        int n = board[0].length;
        List<Integer> neighborsCount = new ArrayList<>();

        for(int i=0; i<m; ++i)
        {
            for(int j=0; j<n; ++j)
            {
                int row = i - 1;
                int col = j - 1;

                int neighborCount = 0;

                if(row > -1 && col > -1 && board[row][col] == 1)
                    neighborCount++;

                col++;

                if(row > -1 && col < n && board[row][col] == 1)
                    neighborCount++;

                col++;

                if(row > -1 && col < n && board[row][col] == 1)
                    neighborCount++;

                row++;
                col = j-1;

                if(row < m && col > -1 && board[row][col] == 1)
                    neighborCount++;

                col = j+1;

                if(row < m && col < n && board[row][col] == 1)
                    neighborCount++;

                row++;
                col = j-1;

                if(row < m && col > -1 && board[row][col] == 1)
                    neighborCount++;

                col++;

                if(row < m && board[row][col] == 1)
                    neighborCount++;

                col++;

                if(row < m && col < n && board[row][col] == 1)
                    neighborCount++;

                neighborsCount.add(neighborCount);
            }
        }


        for(int i=0, count = 0; i<m; ++i)
        {
            for(int j=0; j<n; ++j)
            {
                if(board[i][j] == 0 && neighborsCount.get(count) == 3)
                    board[i][j] = 1;
                else if(board[i][j] == 1 && (neighborsCount.get(count) < 2 || neighborsCount.get(count) > 3))
                    board[i][j] = 0;
                count++;
            }
        }


        for(int i=0; i<m; ++i)
        {
            for(int j=0; j<n; ++j)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
