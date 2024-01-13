package TwoSumII;

public class TwoSumII
{
    public TwoSumII()
    {
        int[] numbers = new int[]{0,2};
        int target = 0;
        System.out.println(twoSum(numbers, target));
    }

    public int[] twoSum(int[] numbers, int target)
    {
        int i = 0, j = numbers.length - 1;
        while(i < j)
        {
            if(numbers[i] + numbers[j] > target)
            {
                j--;
                continue;
            }
            if(numbers[i] + numbers[j] < target)
            {
                i++;
                continue;
            }
            return new int[]{i + 1, j + 1};
        }
        return numbers;
    }
}
