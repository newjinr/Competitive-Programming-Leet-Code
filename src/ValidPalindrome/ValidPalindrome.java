package ValidPalindrome;

public class ValidPalindrome
{
    public ValidPalindrome()
    {
        String s = "10AP     pa01";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
            if(s.charAt(i) < 48 || s.charAt(i) > 57 &&  s.charAt(i) < 65 || s.charAt(i) > 90 && s.charAt(i) < 97 || s.charAt(i) > 122)
            {
                i++;
                continue;
            }
            if(s.charAt(j) < 48 || s.charAt(j) > 57 && s.charAt(j) < 65 || s.charAt(j) > 90 && s.charAt(j) < 97 || s.charAt(j) > 122)
            {
                j--;
                continue;
            }
            if(s.charAt(i) > 47 && s.charAt(i) < 58 && s.charAt(i) - 48 != s.charAt(j) - 48 || s.charAt(i) - 65 != s.charAt(j) - 97 && s.charAt(i) - 97 != s.charAt(j) - 65 && s.charAt(i) - 65 != s.charAt(j) - 65 && s.charAt(i) - 97 != s.charAt(j) - 97)
                return false;
            i++;j--;
        }

        return true;
    }
}
