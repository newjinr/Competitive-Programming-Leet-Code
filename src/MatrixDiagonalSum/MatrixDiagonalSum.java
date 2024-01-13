package MatrixDiagonalSum;

public class MatrixDiagonalSum
{
    public MatrixDiagonalSum()
    {
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat)
    {
        int result = 0;
        int n = mat.length;

        for(int i=0; i<n; ++i)
            result += mat[i][i];

        for(int i=0; i<mat.length; ++i)
            if(i != --n) result += mat[i][n];

        return result;
    }
}
