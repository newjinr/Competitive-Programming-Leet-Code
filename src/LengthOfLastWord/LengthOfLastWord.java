package LengthOfLastWord;

public class LengthOfLastWord
{
    public LengthOfLastWord()
    {
        String s = " newjin ";
        System.out.println(lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s)
    {
        int count = 0;
        for(int i=s.length()-1; i>=0; --i)
        {
            if(count > 0 && s.charAt(i) == 32) break;
            if ((s.charAt(i) >= 97 && s.charAt(i) <= 123 || s.charAt(i) >= 65 && s.charAt(i) <= 91))
            {
                ++count;
            }
        }
        return count;
    }
}
