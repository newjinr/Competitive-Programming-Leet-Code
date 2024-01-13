package BasicCalculator;

import java.util.Stack;

public class BasicCalculator
{
    public BasicCalculator()
    {
        String s = "(6)-(8)-(7)+(1+(6))";
        System.out.println(calculate(s));
    }

    public int calculate(String s)
    {
        int sum = 0;
        int sign = 1;
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<s.length(); ++i)
        {if(s.charAt(i) == ' ') continue;

            if(s.charAt(i) == '+')
            {
                sign = 1;
            }
            else if(s.charAt(i) == '-')
            {
                sign = -1;
            }
            else if(s.charAt(i) == '(')
            {
                stack.push(new int[]{sum, sign});
                sum = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')')
            {
                int[] num = stack.pop();
                sum = num[0] + (num[1] * sum);
            }
            else
            {
                int number = 0;
                while(i<s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57)
                    number = (number*10) + (s.charAt(i++) - 48);
                sum += number * sign;
                i--;
            }
        }


        return sum;
    }
}
