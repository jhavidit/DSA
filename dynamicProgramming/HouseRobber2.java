package dynamicProgramming;

import java.util.ArrayList;

public class HouseRobber2 {

    public static int rob(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int k = 0, l = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                arr1[k] = arr[i];
                k++;
            }
            if (i != n - 1) {
                arr2[l] = arr[i];
                l++;
            }
        }
        return Math.max(maximumSumSpaceOptimized(arr1), maximumSumSpaceOptimized(arr2));


    }

    public static int maximumSumSpaceOptimized(int[] arr) {
        int n = arr.length;
        int prev2 = 0;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            int leftJump = arr[i];
            if (i > 1)
                leftJump += prev2;
            int rightJump = prev;
            int curr = Math.max(leftJump, rightJump);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(rob(arr));
    }


}
