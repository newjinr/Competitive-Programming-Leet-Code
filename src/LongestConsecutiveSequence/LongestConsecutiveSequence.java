package LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.Map;

public class LongestConsecutiveSequence
{
    public LongestConsecutiveSequence()
    {
        int[] nums = new int[]{1,1,1,1};
        System.out.println(longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums)
    {
        if(nums.length == 0)
            return 0;

        int longestSequence = 1;
        Arrays.sort(nums);
        int length = 1;
        int previousNum = nums[0];

        for(int i=1; i<nums.length; ++i)
        {
            if(previousNum == nums[i])
                continue;
            if(nums[i]-1 == previousNum)
                longestSequence = Math.max(longestSequence, ++length);
            else
                length = 1;
            previousNum = nums[i];
        }


        return longestSequence;
    }
}
