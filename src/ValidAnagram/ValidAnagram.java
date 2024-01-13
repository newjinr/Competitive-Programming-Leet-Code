package ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram
{
    public ValidAnagram()
    {
        String s = "";
        String t = "";
        System.out.println(isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t)
    {
        Map<Character, Integer> map = new HashMap<>();

        if(t.length() < s.length()) return false;

        for(int i=0; i<t.length(); ++i)
            map.put(t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i)) + 1 : 1);

        for(int i=0; i<s.length(); ++i)
        {
            if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < 1) return false;
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        return true;
    }
}
