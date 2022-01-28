package leetcode.medium;

import java.util.Arrays;

public class Leet1959 {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            int max = -1;
            int sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                cost[i][j] = (j - i + 1) * max - sum;
            }
        }

        int[][] dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 2; j++) {
                dp[i][j] = 987654321;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                for (int l = 0; l <= i; l++) {
                    dp[i][j] = Math.min(dp[i][j], (l == 0 ? 0 : dp[l - 1][j- 1]) + cost[l][i]);
                }
            }
        }


        return dp[n - 1][k + 1];
    }
}
