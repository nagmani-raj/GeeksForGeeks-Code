class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int max1 = -1;
            int max2 = -1;
            int maxIndex = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] > max1) {
                    max2 = max1;
                    max1 = dp[j];
                    maxIndex = j;
                } else if (dp[j] > max2) {
                    max2 = dp[j];
                }
            }

            int[] newDp = new int[n];

            for (int j = 0; j < n; j++) {
                int bestPrevious = (j == maxIndex) ? max2 : max1;

                newDp[j] = mat[i][j] + bestPrevious;
            }

            dp = newDp;
        }

        int ans = 0;
        for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}