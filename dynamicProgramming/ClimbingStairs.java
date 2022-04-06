package dynamicProgramming;

public class ClimbingStairs {

    static int climbingStairs(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1) {
            return dp[n];
        } else {
            return dp[n] = climbingStairs(n - 1, dp) + climbingStairs(n - 2, dp);
        }
    }
    // TC - O(n)
    // SC - O(n) stack space + O(n)


    //Tabulation
    static int climbingStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }// TC - O(n)
    // SC - O(n)

    //Space Optimized
    static int climbingStairsSpaceOptimized(int n) {
        if (n == 0)
            return 1;
        int prev2 = 1;
        int prev = 1;

        int curr;
        for (int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }// TC - O(n) SC - O(1)

}
