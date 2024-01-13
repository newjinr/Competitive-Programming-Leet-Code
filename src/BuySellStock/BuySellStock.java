package BuySellStock;

public class BuySellStock
{
    public BuySellStock()
    {
        int[] nums = new int[]{0,2,3,4,7,8,1,1,3,9};
        System.out.println(maxProfit(nums));
    }

    public int maxProfit(int[] prices)
    {
        int profit = 0;

        if(prices.length == 1) return profit;

        int buy = prices[0];

        for(int i=0; i<prices.length; ++i)
        {
            profit = Math.max(prices[i] - buy, profit);
            if(prices[i] < buy) buy = prices[i];
        }

        return profit;
    }
}
