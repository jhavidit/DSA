package dynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber {

    //Memoization
    static int fibonacci(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1) {
            return dp[n];
        } else {
            return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        }
    }
    // TC - O(n)
    // SC - O(n) stack space + O(n)


    //Tabulation
    static int fiboanacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }// TC - O(n)
    // SC - O(n)

    //Space Optimized
    static int fibonacciSpaceOptimized(int n) {
        int prev2 = 0;
        int prev = 1;
        int curr;
        for (int i = 0; i < n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }// TC - O(n) SC - O(1)

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacci(n, dp));
    }
}
