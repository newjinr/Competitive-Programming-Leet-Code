package InsertInterval;

import java.util.ArrayList;

public class InsertInterval
{
    public InsertInterval()
    {
        int[][] intervals = new int[][]{{1,5},{8,9}};
        int[] newInterval = new int[]{5,7};
        int[][] ans = insert(intervals, newInterval);

        for (int[] an : ans) System.out.println(an[0] + " " + an[1]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        ArrayList<int[]> ans = new ArrayList<>();

        for(int[] interval : intervals)
        {
            if(interval[1] < newInterval[0]){
                ans.add(interval);
            }
            else if(newInterval[1] < interval[0]){
                ans.add(newInterval);
                newInterval = interval;
            }
            else{
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
        }

        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}
