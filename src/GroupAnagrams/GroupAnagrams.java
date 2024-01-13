package GroupAnagrams;

import java.util.*;

public class GroupAnagrams
{
    public GroupAnagrams()
    {
        String[] strs = new String[]{"eata","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0, j=0; i<strs.length; ++i)
        {
            String string = strs[i];
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if(map.containsKey(sortedString))
            {
                ans.get(map.get(sortedString)).add(string);
                continue;
            }

            map.put(sortedString, j++);
            List<String> temp = new ArrayList<>();
            temp.add(string);
            ans.add(temp);
        }

        return ans;
    }
}
