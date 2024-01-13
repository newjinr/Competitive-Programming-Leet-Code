package MinStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack
{
    private List<Integer> list = new ArrayList<>();
    private int index = -1;
    private Stack<Integer> minStack = new Stack<>();

    public MinStack()
    {

    }

    public void push(int val)
    {
        int min = minStack.isEmpty() ? val : Math.min(minStack.peek(), val);
        minStack.add(min);
        list.add(val);
        index++;
    }

    public void pop()
    {
        minStack.pop();
        list.remove(index);
        index--;
    }

    public int top()
    {
        return list.get(index);
    }

    public int getMin()
    {
        return minStack.peek();
    }
}
