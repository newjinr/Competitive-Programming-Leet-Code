package ArrowsToBurstBalloons;

import java.util.Arrays;

public class ArrowsToBurstBalloons
{
    public ArrowsToBurstBalloons()
    {
//        int[][] points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = new int[][]{{0,9},{2,3},{4,5},{5,6},{6,7}};
        int[][] points = new int[][]{{1,100},{3,4},{5,6},{7,8}};
//        int[][] points = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int n=points.length;

        int ans=1;
        int prevend=points[0][1];
        for(int i=1;i<n;i++)
        {
            if(points[i][0]>prevend){
                ans++;
                prevend=points[i][1];
            }
        }
        return ans;
    }
}
