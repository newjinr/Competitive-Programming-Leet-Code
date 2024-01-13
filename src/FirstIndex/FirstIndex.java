package FirstIndex;

public class FirstIndex
{
    public FirstIndex()
    {
        String s = "newjinLexusewjin";
        String v = "w";

        System.out.println(strStr(s, v));
    }

    public int strStr(String haystack, String needle)
    {
        int lengthOfNeedle = needle.length();

        for(int i=0; i<=haystack.length() - lengthOfNeedle; ++i)
        {
            if(haystack.substring(i, i+lengthOfNeedle).equals(needle))
                return i;
        }

        return -1;
    }
}
