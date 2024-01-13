package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FourSum
{
    private List<List<Integer>> ans = new ArrayList<>();
    private Stack<Integer> temp = new Stack<>();
    private int target = 0;

    public FourSum()
    {
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(fourSum(nums, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        Arrays.sort(nums);
        this.target = target;
        findFourSum(nums, 4, 0, 0);
        return ans;
    }

    public void findFourSum(int[] nums, int k, int start, int sum)
    {
        if(k!=2)
        {
            for(int i=start; i<nums.length - 2; ++i)
            {
                if(i > start && nums[i] == nums[i-1])
                {
                    continue;
                }
                temp.add(nums[i]);
                findFourSum(nums, k-1, i + 1, sum + nums[i]);
                temp.pop();
            }
            return;
        }

        int i = start;
        int j = nums.length - 1;

        while(i < j && temp.size() >= 2)
        {
            Long totalSum = Long.valueOf(sum) + Long.valueOf(nums[i]) + Long.valueOf(nums[j]);
            if(totalSum == target)
            {
                List<Integer> num = new ArrayList<>();
                for(int v=0; v<temp.size(); ++v)
                {
                    num.add(temp.get(v));
                }
                num.add(nums[i]);
                num.add(nums[j]);

                ans.add(num);
                i++;
                while(i<j && nums[i] == nums[i-1]) i++;
            }
            else if(totalSum > target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }

    }
}
