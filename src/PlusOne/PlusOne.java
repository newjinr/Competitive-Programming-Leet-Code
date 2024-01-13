package PlusOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PlusOne
{
    public PlusOne()
    {
        int[] digits = new int[]{9,9,9,9,9};
        int[] ans = plusOne(digits);
        for(int num : ans) System.out.println(num);
    }

    public int[] plusOne(int[] digits)
    {
        int firstone[]=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        firstone[0]=1;
        return firstone;
    }
}
