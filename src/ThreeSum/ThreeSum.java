package ThreeSum;

import java.util.*;

public class ThreeSum
{

    public ThreeSum()
    {
        int[] nums = new int[]{-2,-1,0,1,2,3};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i=0; i<nums.length; ++i)
        {
            if(countMap.containsKey(nums[i]))
            {
                int x = countMap.get(nums[i]) + 1;
                countMap.put(nums[i], x);
            }
            else
            {
                countMap.put(nums[i], 1);
            }
        }

        if(countMap.containsKey(0) && countMap.get(0) >= 3)
        {
            ans.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        }

        for(int i=0; i<nums.length - 2; ++i)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;

            if(nums[i] >= 0)
                break;

            for(int j=nums.length-1; j>i; --j)
            {
                int twoSum = -1 * nums[i] < nums[j] ? nums[i] + nums[j] : -(nums[i] + nums[j]);
                twoSum = nums[i] + nums[j] + twoSum == 0 ? twoSum : -twoSum;

                if(j<nums.length-1 && nums[j] == nums[j+1] || (twoSum > nums[j]) || (twoSum < nums[i]))
                    continue;

                if(countMap.containsKey(twoSum))
                {
                    if(twoSum == nums[i] && countMap.get(twoSum) < 2)
                        continue;
                    if(twoSum == nums[j] && countMap.get(twoSum) < 2)
                        continue;

                    ans.add(new ArrayList<>(Arrays.asList(nums[i], twoSum, nums[j])));
                }
            }
        }

        return ans;
    }
}
