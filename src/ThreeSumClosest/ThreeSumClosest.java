package ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest
{
    public ThreeSumClosest()
    {
        int[] nums = new int[]{321,413,82,812,-646,-858,729,609,-339,483,-323,-399,-82,-455,18,661,890,-328,-311,520,-865,-174,55,685,-636,462,-172,-696,-296,-832,766,-808,-763,853,482,411,703,655,-793,-121,-726,105,-966,-471,612,551,-257,836,-94,-213,511,317,-293,279,-571,242,-519,386,-670,-806,-612,-433,-481,794,712,378,-325,-564,477,169,601,971,-300,-431,-152,285,-899,978,-419,708,536,-816,-335,284,384,-922,-941,633,934,497,-351,62,392,-493,-44,-400,646,-912,-864,835,713,-12,322,-228,340,-42,-307,-580,-802,-914,-142,575,-684,-415,718,-579,759,579,732,-645,525,114,-880,-603,-699,-101,-738,-887,327,192,747,-614,393,97,-569,160,782,-69,235,-598,-116,928,-805,-76,-521,671,417,600,-442,236,831,637,-562,613,-705,-158,-237,-299,808,-734,364,919,251,-163,-343,899};
        System.out.println(threeSumClosest(nums, 2218));
    }

    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length-1];

        for(int i=0; i<nums.length-2; ++i)
        {
            int j = i+1;
            int k = nums.length-1;

            while(j < k)
            {
                if(nums[i] + nums[j] + nums[k] == target)
                {
                    return target;
                }

                if(getClosestNum(i, j, k, nums, target) < Math.abs(ans - target))
                {
                    ans = nums[i] + nums[j] + nums[k];
                }

                if(getClosestNum(i, j+1, k, nums, target) < getClosestNum(i, j, k-1, nums, target))
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return ans;
    }

    public int getClosestNum(int i, int j, int k, int[] nums, int target)
    {
        int num = nums[i] + nums[j] + nums[k];
        return Math.abs(num-target);
    }
}
