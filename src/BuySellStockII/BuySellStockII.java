package BuySellStockII;

public class BuySellStockII
{
    public BuySellStockII()
    {
        int[] nums = new int[]{1,2,1,10};
        System.out.println(maxProfit(nums));
    }

    public int maxProfit(int[] prices)
    {
        int profit = 0;
        for(int i=1; i<prices.length; ++i)
        {
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }

        return profit;
    }
}
