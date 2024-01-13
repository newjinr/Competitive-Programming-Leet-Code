package RemoveDuplicatesII;

public class RemoveDuplicatesII
{
    private int[] ans;

    public RemoveDuplicatesII()
    {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int n = removeDuplicates(nums);

        for(int i=0; i<n; ++i)
        {
            System.out.println(ans[i]);
        }
    }

    public int removeDuplicates(int[] nums)
    {
        int j = 1;
        int count = 1;

        for(int i=1; i < nums.length; ++i)
        {
            if(nums[i] != nums[i-1])
            {
                nums[j++] = nums[i];
                count = 1;
                continue;
            }

            if(nums[i] == nums[i-1] && count < 2)
            {
                nums[j++] = nums[i];
                count++;
            }
        }
        ans = nums;
        return j;
    }
}
