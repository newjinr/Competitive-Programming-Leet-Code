package isSubsequence;

public class IsSubSequence
{
    public IsSubSequence()
    {
        String s = "abc";
        String t = "aghbdho";
        System.out.println(isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t)
    {
        int j = 0;
        for(int i=0; i<t.length(); ++i)
        {
            if(j == s.length()) return true;
            if(t.charAt(i) == s.charAt(j))
                j++;
        }


        return j == s.length();
    }
}
