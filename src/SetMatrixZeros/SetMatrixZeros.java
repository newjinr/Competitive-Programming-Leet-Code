package SetMatrixZeros;

public class SetMatrixZeros
{
    public SetMatrixZeros()
    {
        int[][] matrix = new int[][]{};
        setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] zerosInRow = new int[m];
        int[] zerosInCol = new int[n];

        for(int i=0; i<m; ++i)
            for(int j=0; j<n; ++j)
                if(matrix[i][j] == 0)
                {
                    zerosInRow[i] = 1;
                    zerosInCol[j] = 1;
                }

        for(int i=0; i<m; ++i)
            for(int j=0; j<n; ++j)
                if(zerosInRow[i] == 1 || zerosInCol[j] == 1)
                    matrix[i][j] = 0;
    }
}
