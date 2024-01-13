package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    public RomanToInteger()
    {
        String s = "CMXCIX";
        System.out.println(romanToInt(s));
    }

    public int romanToInt(String s)
    {
        char[] romanChar = s.toCharArray();
        Map<Object, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int ans = romanMap.get(romanChar[0]);


        for(int i=1; i<s.length(); ++i)
        {
            ans += romanMap.get(romanChar[i-1]) >= romanMap.get(romanChar[i]) ? romanMap.get(romanChar[i]) : romanMap.get(romanChar[i]) - 2*romanMap.get(romanChar[i-1]);
        }

        return ans;
    }
}
