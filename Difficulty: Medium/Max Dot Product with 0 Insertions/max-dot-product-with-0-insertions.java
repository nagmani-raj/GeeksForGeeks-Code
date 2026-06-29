class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {
            dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int limit = Math.min(i, m);
            for (int j = 1; j <= limit; j++) {
                dp[i][j] = dp[i - 1][j];

                if (dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i - 1][j - 1] + a[i - 1] * b[j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}