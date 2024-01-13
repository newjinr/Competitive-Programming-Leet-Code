package GasStation;

public class GasStation
{
    public GasStation()
    {
        int[] gas = new int[]{3,1,1};
        int[] cost = new int[]{1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int startIndex = 0;
        int totalBalanceAmount = 0;
        int currentBalanceAmount = 0;

        for(int i=0; i<gas.length; ++i)
        {
            totalBalanceAmount += gas[i] - cost[i];
            if(totalBalanceAmount < currentBalanceAmount)
            {
                startIndex = i+1;
                currentBalanceAmount = totalBalanceAmount;
            }
        }

        return totalBalanceAmount >= 0 ? startIndex : -1;
    }
}
