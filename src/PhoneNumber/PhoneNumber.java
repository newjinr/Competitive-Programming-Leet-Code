package PhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber
{
    private List<String> ans = new ArrayList<>();
    Map<String, String> map = new HashMap<>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");

        }};

    public PhoneNumber()
    {
        System.out.println(letterCombinations("222"));
    }

    public List<String> letterCombinations(String digits)
    {
        findLetterCombination(0, "", new StringBuilder(digits));
        return ans;
    }

    public void findLetterCombination(int i, String currentString, StringBuilder digits)
    {
        if(currentString.length() == digits.length())
        {
            ans.add(currentString);
            return;
        }

        for(char c : map.get(String.valueOf(digits.charAt(i))).toCharArray())
        {
            findLetterCombination(i+1, currentString.concat(String.valueOf(c)), digits);
        }
    }
}
