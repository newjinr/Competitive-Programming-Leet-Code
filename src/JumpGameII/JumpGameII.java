package JumpGameII;


public class JumpGameII
{
    public JumpGameII()
    {
        int[] nums = new int[]{1,1,1,1,4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums)
    {
       int count = 0;

       if(nums.length == 1) return count;

       int maxDistance = 0;
       int max = 0;
       for(int i=0; i<nums.length-1; ++i)
       {
           if(nums[i] + i >= nums.length-1) return ++count;
           max = Math.max(nums[i]+i, max);
           if(i == maxDistance)
           {
               maxDistance = max;
               max = 0;
               count++;
           }
       }
       return count;
    }
}
