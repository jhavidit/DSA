package arrays;

/*package whatever //do not write package name here */

import java.util.*;
public class largest_sum_contiguous_subarray
{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        int msf = Integer.MIN_VALUE, mth = 0;
        for(int i=0;i<n;i++)
        {
            mth+=arr[i];
            if(mth<arr[i])
            mth = arr[i];
            if(msf<mth)
            msf = mth;
        }
        System.out.println(msf);
        in.close();
    }
}
