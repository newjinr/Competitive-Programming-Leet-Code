package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman
{
    public IntegerToRoman()
    {
        int num = 1449;
        System.out.println(intToRoman(num));
    }

    private void convertIntToRoman(Integer num, int value, int addValue, Map<Integer, String> map, String ans, Map numAnsMap)
    {
        if(num < value && num + addValue >= value)
        {
            num %= value - addValue;
            ans += map.get(addValue) + map.get(value);
        }
        else
        {
            int x = num / value;
            for(int i=0; i<x; ++i)
            {
                ans += map.get(value);
            }
            num %= value;
        }
        numAnsMap.put("ans", ans);
        numAnsMap.put("num", num);
    }

    public String intToRoman(int num)
    {
        int j = num;
        String romanResult = "";
        Character ch[] = {'I','X','C','M'};
        Character ch2[] = {'V','L','D'};
        Character ch3[] = {'X','C','M'};

        int i=0;
        while(j > 0)
        {
            int seg = j %10;
            String temp = "";
            switch(seg)
            {
                case 1:
                {
                    temp = temp+ch[i];
                    break;
                }
                case 2:
                {
                    temp = temp+ch[i]+ch[i];
                    break;
                }
                case 3:
                {
                    temp = temp + ch[i] + ch[i] + ch[i];
                    break;
                }
                case 4:
                {
                    temp = temp + ch[i] + ch2[i];
                    break;
                }
                case 5:
                {
                    temp = temp + ch2[i];
                    break;
                }
                case 6:
                {
                    temp = temp + ch2[i] + ch[i];
                    break;
                }
                case 7:
                {
                    temp = temp + ch2[i] + ch[i] + ch[i];
                    break;
                }
                case 8:
                {
                    temp = temp + ch2[i] + ch[i] + ch[i] + ch[i];
                    break;
                }
                case 9:
                {
                    temp = temp + ch[i] + ch3[i];
                    break;
                }
                default:
                {
                    // Do nothing
                    break;
                }
            }
            j = j /10;
            i++;
            romanResult = temp + romanResult;
        }
        return romanResult;
    }
}
