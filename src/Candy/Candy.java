package Candy;

public class Candy
{
    public Candy()
    {
        int[] nums = new int[]{0,1,2,13,9,8,7,3,2,9};
        System.out.println(candy(nums));
    }

    public int candy(int[] ratings)
    {
        int count = ratings.length > 1 && ratings[0] > ratings[1] ? 2 : 1;
        int minCandies = count;

        for(int i=1; i<ratings.length; ++i)
        {
            if(ratings[i] > ratings[i-1])
            {
                ++count;
            }
            else if(ratings[i] < ratings[i-1])
            {
                int candies = 1;
                while(i < ratings.length && ratings[i] < ratings[i-1])
                {
                    candies++;
                    i++;
                }
                i--;
                if(candies > count)
                {
                    minCandies += ((candies*(candies+1))/2)-count;
                }
                else
                {
                    candies--;
                    minCandies += ((candies*(candies+1))/2);
                }
                count = 1;
                continue;
            }
            else
            {
                count = 1;
            }

            minCandies += count;

        }
        return minCandies;
    }
}
