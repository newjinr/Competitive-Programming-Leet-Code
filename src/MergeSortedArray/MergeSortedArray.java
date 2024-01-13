package MergeSortedArray;

public class MergeSortedArray
{

    public MergeSortedArray()
    {
        int[] m = new int[]{2,4,6,7,9,9,10,11,0,0,0,0,0,0,0};
        int[] n = new int[]{1,3,5,8,8,11,13};
        int[] ans = merge(m, 8, n, n.length);

        for(int a : ans)
        {
            System.out.println(a);
        }
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = nums1.length - 1;
        int j = m-1;
        int k = n-1;

        while(k>=0)
        {
            if(j>=0 && nums1[j] > nums2[k])
                nums1[i--] = nums1[j--];
            else
                nums1[i--] = nums2[k--];
        }
        return nums1;
    }
}
