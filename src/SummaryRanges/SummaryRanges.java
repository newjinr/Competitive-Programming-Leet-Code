package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges
{
    public SummaryRanges()
    {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums)
    {
        List<String> ans = new ArrayList<>();
        int previous = nums.length > 0 ? nums[0] : 0;

        for(int i=0; i<nums.length; ++i)
        {
            if(i == nums.length -1 || i < nums.length - 1 && nums[i] + 1 != nums[i+1])
            {
                String s = previous == nums[i] ? String.valueOf(previous) : previous + "->" + nums[i];
                ans.add(s);
                previous = i < nums.length - 1 ? nums[i+1] : 0;
            }
        }

        return ans;
    }
}
