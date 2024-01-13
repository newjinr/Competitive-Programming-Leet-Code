package ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII
{
    public ContainsDuplicateII()
    {
        int[] nums = new int[]{};
        int k = 0;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; ++i)
        {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }
}
