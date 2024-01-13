package ConcatenationOfArray;

public class ConcatenationOfArray
{
    public ConcatenationOfArray()
    {
        int[] nums = new int[]{1};
        int[] ans = getConcatenation(nums);
        for(int num : ans) System.out.println(num);
    }

    public int[] getConcatenation(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n*2];

        for(int i=0; i<n*2; ++i)
            ans[i] = nums[i%n];

        return ans;
    }
}
