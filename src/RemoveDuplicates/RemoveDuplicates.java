package RemoveDuplicates;

public class RemoveDuplicates
{
    private int[] ans;

    public RemoveDuplicates()
    {
        int[] nums = new int[]{0,0,1,1,2,3,4,4,4,5,6,7,7};
        int n = removeDuplicates(nums);

        for(int i=0; i<n; ++i)
        {
            System.out.println(ans[i]);
        }
    }

    public int removeDuplicates(int[] nums)
    {
        int count = 0;
        int j = 1;

        for(int i = 1; i< nums.length; ++i)
        {
            if(nums[i] != nums[i-1])
            {
                nums[j++] = nums[i];
                count++;
            }
        }
        this.ans = nums;

        return count;
    }
}
