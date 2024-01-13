package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals
{
    public MergeIntervals()
    {
        int[][] intervals = new int[][]{{1,4}, {2,3}};
        intervals = merge(intervals);

        for(int i=0; i<intervals.length; ++i)
        {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }
    }

    public int[][] merge(int[][] intervals)
    {
        if(intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedList = new ArrayList<>();

        for(int i=0; i < intervals.length;)
        {
            int[] current = intervals[i];
            int start = current[0];
            int end = current[1];
            while(i < intervals.length && intervals[i][0] <= end){
                end = Math.max(end, intervals[i++][1]);
            }
            mergedList.add(new int[]{start,end});
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
