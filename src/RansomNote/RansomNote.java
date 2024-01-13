package RansomNote;
public class RansomNote
{

    public RansomNote()
    {
        String ransomNote = "newjin";
        String magazine = "wenjin";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine)
    {
        int[] alphabet = new int[26];

        for (char c : ransomNote.toCharArray())
        {
            int index = magazine.indexOf(c, alphabet[(int) c - 97]);
            if (index == -1) return false;
            alphabet[(int) c - 97] = index + 1;
        }

        return true;
    }
}
