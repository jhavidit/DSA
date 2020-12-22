package arrays;

import java.util.Scanner;
public class max_min_element_in_array
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int arr[]=new int[n];
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int a = in.nextInt();
            arr[i] = a;
            if(a<min)
            min=a;
            if(a>max)
            max = a;
        }
        System.out.println("max - "+max+"  min - "+min);
        in.close();
    }
}