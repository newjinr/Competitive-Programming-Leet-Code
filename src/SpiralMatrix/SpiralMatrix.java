package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public SpiralMatrix()
    {
        int[][] matrix = new int[][]{{1,2,3,4,5}, {12,13,14,15,6}, {11,10,9,8,7}};
        System.out.println(spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> ans = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;
        int o = -1;
        int p = 0;
        boolean isRow = true;
        boolean isRight = true;
        boolean isDown = false;
        int row = 0;
        int col = 0;
        int count = 0;
        int totalSquares = m*n;

        while(count < totalSquares)
        {
            ans.add(matrix[row][col]);
            if(isRow)
            {
                if(isRight)
                    col++;
                else
                    col--;

                if(isRight && col == m)
                {
                    m--;
                    col--;
                    row++;
                    isRow = false;
                    isRight = false;
                    isDown = true;
                }
                else if(!isRight && col == o)
                {
                    o++;
                    col++;
                    row--;
                    isRow = false;
                    isRight = true;
                }
            }
            else
            {
                if(isDown)
                    row++;
                else
                    row--;

                if(isDown && row == n)
                {
                    n--;
                    row--;
                    col--;
                    isDown = false;
                    isRow = true;
                }
                else if(!isDown && row == p)
                {
                    p++;
                    col++;
                    row++;
                    isDown = true;
                    isRow = true;
                }
            }
            count++;
        }

        return ans;
    }
}
