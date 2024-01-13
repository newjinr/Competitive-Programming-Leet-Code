package RemoveElement;

public class RemoveElement
{
    private int[] ans;
    public RemoveElement()
    {
        int[] nums = new int[]{1,3,2,3,4,3,5,3,6,7,3};
        int n = removeElement(nums, 3);

        for(int i=0; i<n; ++i)
        {
            System.out.println(ans[i]);
        }
    }

    public int removeElement(int[] nums, int val)
    {
        int i = 0;
        int j = 0;
        int count = 0;

        while(i < nums.length)
        {
            if(nums[i] == val)
            {
                count++;
                i++;
                continue;
            }
            nums[j] = nums[i];
            i++;
            j++;
        }

        ans = nums;
        return nums.length - count;
    }
}
