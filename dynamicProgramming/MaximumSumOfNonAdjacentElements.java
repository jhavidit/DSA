package dynamicProgramming;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

    // Memoization
    public static int maximumSum(int[] arr, int ind, int[] dp) {
        if (ind < 0)
            return 0;
        if (ind == 0)
            return arr[ind];
        if (dp[ind] != -1) return dp[ind];
        int rightJump = maximumSum(arr, ind - 1, dp);
        int leftJump = maximumSum(arr, ind - 2, dp) + arr[ind];
        return dp[ind] = Math.max(rightJump, leftJump);
    }

    // Tabulation
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int leftJump = arr[i];
            if (i > 1) {
                leftJump += dp[i - 2];
            }
            int rightJump = dp[i - 1];
            dp[i] = Math.max(rightJump, leftJump);
        }
        return dp[n - 1];
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
        int[] arr = {2, 7, 9, 3, 1};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(maximumSum(arr, n - 1, dp));
        System.out.println(maximumSum(arr));
        System.out.println(maximumSumSpaceOptimized(arr));
    }

}
