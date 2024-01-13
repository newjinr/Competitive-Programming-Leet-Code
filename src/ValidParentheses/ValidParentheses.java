package ValidParentheses;

import java.util.Stack;

public class ValidParentheses
{
    public ValidParentheses()
    {
        String s = "[]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); ++i)
        {
            if(stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'))
                return false;
            if(s.charAt(i) == ')' && stack.peek() != '(' || s.charAt(i) == ']' && stack.peek() != '[' || s.charAt(i) == '}' && stack.peek() != '{')
                return false;
            if(s.charAt(i) == ')' && stack.peek() == '(' || s.charAt(i) == ']' && stack.peek() == '[' || s.charAt(i) == '}' && stack.peek() == '{')
                stack.pop();
            else
                stack.add(s.charAt(i));
        }

        return stack.isEmpty();
    }
}
