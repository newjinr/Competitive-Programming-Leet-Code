package TwoStringsAnagram;

public class TwoStringsAnagram
{

    public TwoStringsAnagram()
    {
        String s = "leetcode";
        String t = "practice";

        System.out.println(minSteps(s, t));
    }

    public int minSteps(String s, String t)
    {
        int ans = 0;
        if(s.equals(t)) return ans;

        int[] num = new int[26];
        for(int i=0; i<s.length(); ++i)
        {
            num[s.charAt(i) - 97]++;
        }

        for(int i=0; i<s.length(); ++i)
        {
            if(num[t.charAt(i) - 97] > 0)
            {
                num[t.charAt(i) - 97]--;
                continue;
            }
            ans++;
        }
        return ans;
    }
}
