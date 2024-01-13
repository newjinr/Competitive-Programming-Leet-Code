package MajorityElement;

import java.util.Arrays;

public class MajorityElement
{
    public MajorityElement()
    {
        int[] nums = new int[]{3,3,3,3};
        int n = removeDuplicates(nums);

        System.out.println(n);
    }

    public int removeDuplicates(int[] nums)
    {
        Arrays.sort(nums);
        int ans = nums[0];
        int greatestCount = 1;
        int count = 1;

        for(int i=1; i<nums.length; ++i)
        {
            if(nums[i] != nums[i-1])
            {
                if(count > greatestCount)
                {
                    ans = nums[i-1];
                }
                greatestCount = count;
                count = 1;
                continue;
            }
            if(nums[i] == nums[i-1]) count++;
        }

        return count > greatestCount ? nums[nums.length-1] : ans;
    }
}
