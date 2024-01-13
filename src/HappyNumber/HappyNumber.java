package HappyNumber;


import java.util.HashSet;
import java.util.Set;

public class HappyNumber
{
    public HappyNumber()
    {
        int n = 0;
        System.out.println(isHappy(n));
    }

    public boolean isHappy(int n)
    {
        Set<Integer> set = new HashSet<>();
        int temp = n;

        while(temp != 1)
        {
            int total = 0;
            while(temp != 0)
            {
                int num = temp%10;;
                total += num * num;
                temp /= 10;
            }

            if(set.contains(total)) return false;
            else set.add(total);
            temp = total;
        }

        return true;
    }
}
