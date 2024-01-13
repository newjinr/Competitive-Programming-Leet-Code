package IsomorphicString;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString
{
    public IsomorphicString()
    {
        String s = "";
        String t = "";
        System.out.println(isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t)
    {
        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); ++i)
        {
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i) || !map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))) return false;
            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
