package SubStringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords
{
    public SubStringWithConcatenationOfAllWords()
    {
        String s = "abefdcd";
        String[] words = new String[]{"ab","cd","ef"};
        System.out.println(findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> ans = new ArrayList<>();
        int singleWordLength = words[0].length();
        int length = words.length;
        int totalLength = singleWordLength * length;
        if(totalLength > s.length()) return ans;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
        {
            if (!map.containsKey(word))
            {
                map.put(word, 1);
                continue;
            }
            int count = map.get(word) + 1;
            map.put(word, count);
        }

        int lastWindow = s.length() - totalLength;
        for(int i=0; i<=lastWindow; ++i)
        {
            int startWindow = i;
            int temp = length;
            Map<String, Integer> tempMap = new HashMap<>(map);

            while(temp-- > 0)
            {
                String word = s.substring(startWindow, startWindow+singleWordLength);
                if(!tempMap.containsKey(word) || tempMap.get(word) == 0) break;
                else
                {
                    int count = tempMap.get(word) - 1;
                    tempMap.put(word, count);
                }
                startWindow += singleWordLength;
            }

            if(temp < 0) ans.add(i);
        }

        return ans;
    }
}
