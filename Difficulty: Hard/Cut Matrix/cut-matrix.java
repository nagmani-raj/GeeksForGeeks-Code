class Solution {
    public int findWays(int[][] matrix, int k) {
        int MOD = 1000000007;
        int n = matrix.length;
        int m = matrix[0].length;

        // apples[i][j] stores the number of 1s in the submatrix from (i, j) to (n-1, m-1)
        int[][] apples = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                apples[i][j] = matrix[i][j] + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];
            }
        }

        // Precompute the next valid row/col cut indices to ensure the top/left piece gets at least one '1'
        int[][] next_r = new int[n][m];
        int[][] next_c = new int[n][m];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (apples[i][j] == 0) {
                    next_r[i][j] = n;
                    next_c[i][j] = m;
                } else {
                    if (i + 1 < n && apples[i + 1][j] < apples[i][j]) {
                        next_r[i][j] = i + 1;
                    } else if (i + 1 < n) {
                        next_r[i][j] = next_r[i + 1][j];
                    } else {
                        next_r[i][j] = n;
                    }

                    if (j + 1 < m && apples[i][j + 1] < apples[i][j]) {
                        next_c[i][j] = j + 1;
                    } else if (j + 1 < m) {
                        next_c[i][j] = next_c[i][j + 1];
                    } else {
                        next_c[i][j] = m;
                    }
                }
            }
        }

        // dp[i][j] represents ways to cut the (i, j) to (n-1, m-1) submatrix
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        // Build up state answers for p cuts up to k cuts
        for (int p = 2; p <= k; p++) {
            int[][] next_dp = new int[n][m];
            int[][] rowSum = new int[n + 1][m];
            int[][] colSum = new int[n][m + 1];

            // Suffix sums trick to evaluate valid cut paths in O(1) time
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    rowSum[i][j] = (rowSum[i + 1][j] + dp[i][j]) % MOD;
                    colSum[i][j] = (colSum[i][j + 1] + dp[i][j]) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (apples[i][j] == 0) continue;

                    int nr = next_r[i][j];
                    int nc = next_c[i][j];

                    int ways = 0;
                    if (nr < n) ways = (ways + rowSum[nr][j]) % MOD;
                    if (nc < m) ways = (ways + colSum[i][nc]) % MOD;

                    next_dp[i][j] = ways;
                }
            }
            dp = next_dp;
        }

        return dp[0][0];
    }
}