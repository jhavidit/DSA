package arrays;

import java.util.Scanner;


public class reverse_array {
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        int i=0,l=n-1;
        while(i<l)
        {
            int t = arr[i];
            arr[i] = arr[l];
            arr[l] = t;
            i++;
            l--;
        }
        for(int j=0;j<n;j++)
        {
            System.out.print(arr[j]+" ");
        }
        in.close();

    }
    
}
