package MinWinSubString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinWinSubString
{
    public MinWinSubString()
    {
        String s = "acbdbaab";
        String t = "aabd";

        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t)
    {
        int map[] = new int[128];
        int start=0,end = 0;
        int count = t.length();
        int min_len= Integer.MAX_VALUE;
        int head = 0;

        for(char c:t.toCharArray()){
            map[c]++;
        }

        char[] arr = s.toCharArray();

        while(end<s.length()){

            if(map[ arr[end++]]-- >0){
                count--;
            }

            while(count ==0){

                if(end-start < min_len){
                    head = start;
                    min_len = end - start;
                }

                if(map[arr[start++]]++ ==0){
                    count++;
                }
            }

        }

        return min_len == Integer.MAX_VALUE?"":s.substring(head,head+min_len);
    }

}
