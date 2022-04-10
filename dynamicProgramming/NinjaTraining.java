package dynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxPoints(points, n - 1, 3, dp);
    }

    // Memoization
    public static int maxPoints(int[][] points, int ind, int last, int[][] dp) {
        if (ind == 0) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (j != last) {
                    max = Math.max(max, points[0][j]);
                }
            }
            return max;
        }

        if (dp[ind][last] != -1) return dp[ind][last];
        int max = 0;

        for (int j = 0; j < 3; j++) {
            if (j != last) {
                max = Math.max(max, maxPoints(points, ind - 1, j, dp) + points[ind][j]);
            }
        }
        return dp[ind][last] = max;
    } // TC - O(N*4)*3  SC - O(N) + O(N*3)

    public static int ninjaTrainingTabulation(int[][] points, int n) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][2], points[0][1]));
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }
    // TC - O(N*4*3)
    // SC - O(N*4)

    public static int ninjaTrainingSpaceOptimization(int[][] points, int n) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][2], points[0][1]));
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {

                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    } // TC - O(N*4*3) SC - O(4)



    public static void main(String[] args) {
        int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        System.out.println(ninjaTraining(3, points));
        System.out.println(ninjaTrainingTabulation(points, 3));
        System.out.println(ninjaTrainingSpaceOptimization(points, 3));
    }

}
