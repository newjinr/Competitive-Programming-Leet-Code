package ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf
{
    public ProductOfArrayExceptSelf()
    {
        int[] nums = new int[]{1,2,3,4};
        int[] ans = productExceptSelf(nums);

        for(int a : ans)
            System.out.println(a);
    }

    public int[] productExceptSelf(int[] nums)
    {
        int length = nums.length-1;
        int[] ans = new int[nums.length];
        int product = 1;

        for(int i=0; i<nums.length; ++i)
        {
            ans[i] = product;
            product *= nums[i];
        }

        product=1;
        for(int i=length; i>=0; --i)
        {
            ans[i] *= product;
            product *= nums[i];
        }

        return ans;
    }
}
