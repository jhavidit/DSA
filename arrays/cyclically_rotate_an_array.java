package arrays;

/*package whatever //do not write package name here */

import java.util.*;


class GFG {
	public static void main (String[] args) {
	    Scanner in =new Scanner(System.in);
	    int t=in.nextInt();
	    while(t-->0)
	    {
	    int n = in.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i] = in.nextInt();
	    }
	    int a = arr[n-1];
	    for(int i=n-2;i>=0;i--)
	    {
	        arr[i+1]=arr[i];
	    }
			// predefined functio  to cirulate array
			System.arraycopy(arr, 0, arr, 1, n - 2 + 1);
	    arr[0] = a;
	    for(int i=0;i<n;i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
        }
        in.close();
	}
}
