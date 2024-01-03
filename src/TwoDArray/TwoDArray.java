package TwoDArray;

import java.util.*;

public class TwoDArray
{
    public TwoDArray()
    {
        int[] nums = new int[]{1,2,3,4,1,2,3,4,4};
        System.out.println(findMatrixShorterCode(nums));
    }

    public List<List<Integer>> findMatrix(int[] nums)
    {
        List<List<Integer>> matrix = new ArrayList<>();
        Arrays.sort(nums);

        Map<Integer, Integer> numCount = new HashMap<>();
        List<Integer> rowList = new ArrayList<>();
        int matrixSize = 0;

        for(int i=0; i<nums.length; ++i)
        {
            if(!rowList.contains(nums[i]))
            {
                rowList.add(nums[i]);
            }
            if(numCount.containsKey(nums[i]))
            {
                int count = numCount.get(nums[i]) + 1;
                matrixSize = Math.max(matrixSize, count);
                numCount.put(nums[i], count);
            }
            else
            {
                numCount.put(nums[i], 0);
            }
        }

        matrix.add(rowList);

        for(int i=0; i<matrixSize; ++i)
        {
            List<Integer> nextRow = new ArrayList<>();
            for(int j=0; j<rowList.size(); ++j)
            {
                if(numCount.get(rowList.get(j)) != 0)
                {
                    nextRow.add(rowList.get(j));
                    int count = numCount.get(rowList.get(j)) - 1;
                    numCount.put(rowList.get(j), count);
                }
            }
            matrix.add(nextRow);
        }
        return matrix;
    }

    public List<List<Integer>> findMatrixShorterCode(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < n; i++)
        {
            if(ans.size() <= k)
            {
                ans.add(new ArrayList<>());
            }

            ans.get(k).add(nums[i]);

            if(i+1 < n && nums[i] != nums[i+1])
            {
                k=0;
            }
            else k++;
        }
        return ans;
    }
}
