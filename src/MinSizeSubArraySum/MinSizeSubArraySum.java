package MinSizeSubArraySum;

public class MinSizeSubArraySum
{
    public MinSizeSubArraySum()
    {
        int target = 7;
        int[] nums = new int[]{1,2,3,4,3,2,1,3};
        System.out.println(minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums)
    {
        int length = Integer.MAX_VALUE;
        int total = 0;
        int i=0, j=0;

        if(target == 0)
            return 1;


        while(i < nums.length)
        {
            if(total < target && j >= nums.length) break;
            if(total == target)
            {
                if(i==j) return 1;
                length = Math.min(length, j - i);
                total -= nums[i];
                i++;
                continue;
            }

            if(total < target)
            {
                total += nums[j];
                j++;
                continue;
            }

            length = Math.min(length, j - i);
            total -= nums[i];
            i++;
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
