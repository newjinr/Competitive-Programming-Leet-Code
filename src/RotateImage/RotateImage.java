package RotateImage;

public class RotateImage
{
    public RotateImage()
    {
        int[][] matrix = new int[][]{{1,2},{3,4}};
        rotate(matrix);
    }

    public void rotate(int[][] matrix)
    {
        int n = matrix.length;

        for(int i=0; i<n; ++i)
        {
            int start = 0;
            int end = n-1;

            while(start < end)
            {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        int col = n-1;
        for(int i=0; i<n-1; ++i)
        {
            int count = n - 2 - i;
            int row = i + 1;
            while(count >= 0)
            {
                int temp = matrix[i][count];
                matrix[i][count--] = matrix[row][col];
                matrix[row++][col] = temp;
            }

            col--;
        }

        for(int i=0; i<n; ++i)
        {
            for(int j=0; j<n; ++j)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
