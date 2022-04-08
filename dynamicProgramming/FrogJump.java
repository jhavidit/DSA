package dynamicProgramming;

import java.util.Arrays;

public class FrogJump {

    //Memoization
    public static int frogJump(int[] arr, int[] dp, int ind) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1) return dp[ind];
        int rightJump = Integer.MAX_VALUE;
        int leftJump = frogJump(arr, dp, ind - 1) + Math.abs(arr[ind] - arr[ind - 1]);
        if (ind > 1)
            rightJump = frogJump(arr, dp, ind - 2) + Math.abs(arr[ind] - arr[ind - 2]);
        return dp[ind] = Math.min(leftJump, rightJump);
    }
    // TC - O(n) SC - O(n)+O(n)

    //Tabulation
    public static int frogJump(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int rightJump = Integer.MAX_VALUE;
            int leftJump = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            if (i > 1) {
                rightJump = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(leftJump, rightJump);
        }
        return dp[n - 1];
    } // TC - O(N)  SC - O(N)


    // Space Optimized Method
    public static int frogJumpSpaceOptimized(int[] arr) {
        int n = arr.length;
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int rightJump = Integer.MAX_VALUE;
            int leftJump = prev + Math.abs(arr[i] - arr[i - 1]);
            if (i > 1) {
                rightJump = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }
            int curr = Math.min(leftJump, rightJump);
            prev2 = prev;
            prev = curr;
        }
        return prev;

    }
    // TC - O(n) SC - O(1)

    public static void main(String[] args) {
        int[] arr = {7, 4, 4, 2, 6, 6, 3, 4};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(arr, dp, n - 1));
        System.out.println(frogJump(arr));
        System.out.println(frogJumpSpaceOptimized(arr));
    }

}
