package HIndex;

import java.util.Arrays;

public class HIndex
{
    public HIndex()
    {
        int[] citations = new int[]{1,2,3,4,5,6};
        System.out.println(hIndex(citations));
    }

    public int hIndex(int[] citations)
    {
        Arrays.sort(citations);
        int startIndex = 0;
        int length = citations.length-1;

        for (int citation : citations)
        {
            if (citation != 0)
                break;
            startIndex++;
        }

        int count = 0;
        while(startIndex <= length)
        {
            if(count > 1 && citations[length] != citations[length+1] && count >= citations[length]) return count;
            if(count >= citations[length]) return citations[length];
            length--;
            count++;
        }

        return count;
    }
}
