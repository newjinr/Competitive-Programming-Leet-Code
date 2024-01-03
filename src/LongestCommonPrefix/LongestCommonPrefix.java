package LongestCommonPrefix;

import java.util.Arrays;

public class LongestCommonPrefix
{
    public LongestCommonPrefix()
    {
        String[] strs = new String[]{"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs)
    {
        Arrays.sort(strs);
        String string = strs[0];
        String commonPrefix = "";

        for(int i=1; i<strs.length; ++i)
        {
            if(string.length() > strs[i].length())
            {
                String temp = strs[i];
                strs[i] = string;
                string = temp;
            }

            while(true)
            {
                int lastIndex = string.length();
                if(string.equals(strs[i].substring(0, lastIndex)))
                {
                    commonPrefix = string;
                    break;
                }
                else
                {
                    string = string.substring(0, lastIndex - 1);
                }
            }
        }

        return strs.length == 1 ? string : commonPrefix;
    }
}
