package WordPattern;

import java.util.HashMap;
import java.util.Map;

public class WordPattern
{
    public WordPattern()
    {
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s)
    {
        s += ' ';
        int startIndex = 0;
        int patternIndex = 0;
        int length = pattern.length();
        Map<String, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); ++i)
        {
            if(s.charAt(i) == ' ')
            {
                String subString = s.substring(startIndex, i);
                if(patternIndex >= length || map.containsKey(subString) && map.get(subString) != pattern.charAt(patternIndex) || !map.containsKey(subString) && map.containsValue(pattern.charAt(patternIndex)))
                    return false;
                map.put(subString, pattern.charAt(patternIndex++));
                startIndex = i+1;
            }
        }
        return patternIndex == pattern.length();
    }
}
