package TextJustification;


import java.util.ArrayList;
import java.util.List;

public class TextJustification
{
    public TextJustification()
    {
        String[] words = new String[]{"What","must","be","shall","be."};
        int maxWidth = 5;
        System.out.println(fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> ans = new ArrayList<>();
        int count = 0;
        int stringCount = 0;
        List<Integer> indexes = new ArrayList<>();
        List<Integer> wordCount = new ArrayList<>();

        for(int i=0; i<words.length; ++i)
        {
            stringCount += words[i].length();
            if(words[i].length() + count == maxWidth)
            {
                indexes.add(i);
                wordCount.add(stringCount);
                stringCount = 0;
                count = 0;
                continue;
            }
            else if(words[i].length() + count > maxWidth)
            {
                indexes.add(i-1);
                wordCount.add(stringCount - words[i].length());
                stringCount = words[i].length();
                count = 0;
            }
            count += words[i].length() + 1;
        }

        int previousIndex = 0;
        for(int i=0; i<indexes.size(); ++i)
        {
            int index = indexes.get(i) - previousIndex;
            int remainingSpaces = maxWidth - wordCount.get(i);
            int whiteSpaceCount = 0;
            int remaining = 0;
            StringBuilder justifiedWord = new StringBuilder();
            justifiedWord.append(words[previousIndex]);
            while(index == 0 && remainingSpaces > 0)
            {
                justifiedWord.append(" ");
                remainingSpaces--;
            }
            if(index > 0)
            {
                whiteSpaceCount = remainingSpaces/index;
                remaining = remainingSpaces%index;
            }
            for(int j=previousIndex+1; j<=indexes.get(i); ++j)
            {
                int spaceCount = remaining-- > 0 ? whiteSpaceCount + 1 : whiteSpaceCount;
                remainingSpaces -= spaceCount;
                while(spaceCount-- > 0)
                    justifiedWord.append(" ");
                justifiedWord.append(words[j]);
            }
            ans.add(justifiedWord.toString());
            previousIndex = indexes.get(i)+1;
        }

        int remainingSpaces = maxWidth - stringCount;
        StringBuilder justifiedWord = new StringBuilder();
        for(int i=previousIndex; i<words.length; ++i)
        {
            justifiedWord.append(words[i]);
            if(remainingSpaces>0)
            {
                justifiedWord.append(" ");
                remainingSpaces--;
            }

            if(i == words.length-1)
                while (remainingSpaces-- > 0) justifiedWord.append(" ");
        }
        if(justifiedWord.toString().length() > 0) ans.add(justifiedWord.toString());
        return ans;
    }
}
