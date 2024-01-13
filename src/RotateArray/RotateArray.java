package RotateArray;


public class RotateArray
{
    private int[] ans;

    public RotateArray()
    {
        int[] nums = new int[]{1,2};
        rotate(nums, 5);

        for(int i=0; i<ans.length; ++i)
        {
            System.out.println(ans[i]);
        }
    }

    public void rotate(int[] nums, int k)
    {
        if(nums.length == 1) return;
        k = k % nums.length;
        int i = 0;
        int j = nums.length - 1;

        while(i < j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }

        i = 0;
        j = k-1;

        while(i < j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }

        i = k;
        j = nums.length - 1;

        while(i < j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }

        ans = nums;
    }
}
