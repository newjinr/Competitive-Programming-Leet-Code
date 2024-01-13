package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz
{
    public FizzBuzz()
    {

    }

    public List<String> fizzBuzz(int n)
    {
        List<String> result = new ArrayList<>();

        for(int i=0; i<n; ++i)
        {
            int num = i+1;
            if(num%3 == 0 && num%5 == 0)
                result.add("FizzBuzz");
            else if(num%3 == 0)
                result.add("Fizz");
            else if(num%5 == 0)
                result.add("Buzz");
            else
                result.add(String.valueOf(num));
        }

        return result;
    }
}
