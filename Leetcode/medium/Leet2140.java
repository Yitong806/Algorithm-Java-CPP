public class Leet2140 {
    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            long skip = dp[i + 1];
            long choose = questions[i][0];
            if(i + questions[i][1] + 1 < n){
                choose += dp[i + questions[i][1] + 1];
            }

            dp[i] = Math.max(skip, choose);
        }

        return dp[0];
    }
}
