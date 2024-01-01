package AssignCookies;


import java.util.Arrays;

public class AssignCookies
{
    public AssignCookies()
    {
        int[] g = new int[]{1,2};
        int[] s = new int[]{1,2,3};

        System.out.println(findContentChildrenUsingSort(g, s));
    }

    public int findContentChildren(int[] g, int[] s)
    {
        int contentChildren = 0;

        for(int i = 0; i < g.length; i++)
        {
            int previousCookieSize = Integer.MAX_VALUE;
            int indexOfPreviousCookie = -1;
            int currentChildContent = g[i];
            boolean foundCookie = false;

            for(int j = 0; j < s.length; j++)
            {
                if(s[j] != 0)
                {
                    if(currentChildContent == s[j])
                    {
                        s[j] = 0;
                        contentChildren++;
                        foundCookie = true;
                        break;
                    }
                    else if(s[j] > currentChildContent && s[j] < previousCookieSize)
                    {
                        previousCookieSize = s[j];
                        indexOfPreviousCookie = j;
                    }
                }
            }

            if(!foundCookie && previousCookieSize > currentChildContent && indexOfPreviousCookie != -1)
            {
                contentChildren++;
                s[indexOfPreviousCookie] = 0;
            }
        }

        return contentChildren;
    }

    public int findContentChildrenUsingSort(int[] g, int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;


        for(int i = g.length-1, j = s.length-1; i>=0; i--)
        {
            if(j >= 0 && g[i] <= s[j])
            {
                contentChildren++;
                j--;
            }
        }

        return contentChildren;
    }
}
