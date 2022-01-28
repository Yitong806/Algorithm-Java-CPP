package leetcode.contest.week276;

public class Leet2140 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[200005];
        for (int i = questions.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + questions[i][1]] + questions[i][0]);
        }
        return dp[0];
    }
}
