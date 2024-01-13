package EvaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateReversePolishNotation
{
    public EvaluateReversePolishNotation()
    {
        String[] tokens = new String[]{"2", "-2", "-"};
        System.out.println(evalRPN(tokens));
    }

    public int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(String token : tokens)
        {
            if("+".equals(token))
            {
                result = stack.pop() + stack.pop();
            }
            else if("-".equals(token))
            {
                int num1 = stack.pop();
                result = stack.pop() - num1;
            }
            else if("*".equals(token))
            {
                result = stack.pop() * stack.pop();
            }
            else if("/".equals(token))
            {
                int num1 = stack.pop();
                result = stack.pop() / num1;
            }
            else
            {
                result = Integer.parseInt(token);
            }
            stack.push(result);

        }

        return result;
    }
}
