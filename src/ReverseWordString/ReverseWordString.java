package ReverseWordString;

public class ReverseWordString
{
    public ReverseWordString()
    {
        String s = "newjin";
        System.out.println(reverseWords(s));
    }

    public String reverseWords(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();

        int length = s.length();
        int j= s.charAt(s.length()-1) == 32 ? s.length()-1 : s.length();

        for(int i=length-1; i>=0; --i)
        {
            while(i>0 && s.charAt(i) == 32 & s.charAt(i-1) == 32)
            {
                i--;
                j--;
            }
            if(i>0 && s.charAt(i) !=32 && s.charAt(i-1) == 32)
            {
                if(stringBuilder.length() > 0)
                    stringBuilder.append(" ").append(s, i, j);
                else
                    stringBuilder.append(s, i, j);
                j=i-1;
            }
            if(i == 0 && s.charAt(i) != 32)
            {
                if(stringBuilder.length()>0)
                    stringBuilder.append(" ").append(s, i, j);
                else
                    stringBuilder.append(s, i, j);
            }
        }
        return stringBuilder.toString();
    }
}
