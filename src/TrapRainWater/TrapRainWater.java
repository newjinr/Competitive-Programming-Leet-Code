package TrapRainWater;

public class TrapRainWater
{
    public TrapRainWater()
    {
        int[] height = new int[]{8,0,0,8};
        System.out.println(trap(height));
    }

    public int trap(int[] height)
    {
        int units = 0;
        int i = 0;
        int j = height.length-1;
        int leftHeight = height[0];
        int rightHeight = height[j];

        while(i<j)
        {
            if(height[j] > height[i])
            {
                leftHeight = Math.max(leftHeight, height[i]);
                if(leftHeight > height[i]) units += leftHeight - height[i];
                ++i;
                continue;
            }
            rightHeight = Math.max(rightHeight, height[j]);
            if(rightHeight > height[j]) units += rightHeight - height[j];
            --j;
        }

        return units;
    }
}
