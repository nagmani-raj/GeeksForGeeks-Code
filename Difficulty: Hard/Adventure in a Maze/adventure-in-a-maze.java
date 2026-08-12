class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        final int MOD = 1_000_000_007;

        long[][] ways = new long[n][n];
        int[][] maxAdventure = new int[n][n];

        ways[0][0] = 1;
        maxAdventure[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3) &&
                    ways[i - 1][j] > 0) {

                    ways[i][j] = (ways[i][j] + ways[i - 1][j]) % MOD;

                    maxAdventure[i][j] = Math.max(
                        maxAdventure[i][j],
                        maxAdventure[i - 1][j] + grid[i][j]
                    );
                }

                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3) &&
                    ways[i][j - 1] > 0) {

                    ways[i][j] = (ways[i][j] + ways[i][j - 1]) % MOD;

                    maxAdventure[i][j] = Math.max(
                        maxAdventure[i][j],
                        maxAdventure[i][j - 1] + grid[i][j]
                    );
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (ways[n - 1][n - 1] == 0) {
            ans.add(0);
            ans.add(0);
        } else {
            ans.add((int) ways[n - 1][n - 1]);
            ans.add(maxAdventure[n - 1][n - 1]);
        }

        return ans;
    }
}