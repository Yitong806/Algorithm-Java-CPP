package leetcode.hard;

public class Leet0072 {
    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int insert = dp[i - 1][j] + 1;
                int delete = dp[i][j - 1] + 1;
                int modify = dp[i - 1][j - 1] + 1;
                dp[i][j] = min(insert, delete, modify);
            }
        }

        return dp[m][n];
    }
}
