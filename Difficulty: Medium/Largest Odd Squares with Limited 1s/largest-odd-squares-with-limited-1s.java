class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pref = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j]
                        + pref[i][j + 1]
                        + pref[i + 1][j]
                        - pref[i][j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];

            int maxRadius = Math.min(
                    Math.min(r, n - 1 - r),
                    Math.min(c, m - 1 - c)
            );

            int lo = 0, hi = maxRadius;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                int top = r - mid;
                int bottom = r + mid;
                int left = c - mid;
                int right = c + mid;

                int ones = pref[bottom + 1][right + 1]
                         - pref[top][right + 1]
                         - pref[bottom + 1][left]
                         + pref[top][left];

                if (ones <= k) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            ans.add(2 * hi + 1);
        }

        return ans;
    }
}