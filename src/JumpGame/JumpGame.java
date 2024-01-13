package JumpGame;

import java.util.ArrayList;
import java.util.List;

public class JumpGame
{
    public JumpGame()
    {
        int[] nums = new int[]{2,0,9,0,0,1,0};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums)
    {
        List<Integer> indexOfZero = new ArrayList<>();
        for(int i=0; i<nums.length-1; ++i)
            if((nums[i] == 0 && nums[i+1] != 0) || (i == nums.length - 2 && nums[i] == 0))
                indexOfZero.add(i);

        if(indexOfZero.size() == 0) return true;

        for(int i=0, j=0; i<nums.length-1; ++i)
        {
            if(i >= indexOfZero.get(j))
                return false;
            if(nums[i] + i >= nums.length - 1)
                return true;
            if(nums[i] + i > indexOfZero.get(j))
            {
                j++;
                if(j >= indexOfZero.size())
                    return true;
            }
        }
        return false;
    }
}
