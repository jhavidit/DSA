package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpWithKDistance {

    // Memoization Method
    public static int frogJump(int[] arr, int ind, int[] dp, int k) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1) return dp[ind];
        int jump = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0)
                jump = Math.min(jump, frogJump(arr, ind - j, dp, k) + Math.abs(arr[ind] - arr[ind - j]));
        }
        return dp[ind] = jump;
    }
    // TC - O(nk) SC - O(n)+O(n)

    public static int frogJump(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int jump = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    jump = Math.min(jump, dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                }
            }
            dp[i] = jump;
        }
        return dp[n - 1];
    }

    // TC - O(nk) SC - O(n)


    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        int n = arr.length;
        int k = 2;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(arr, k));
    }
}
