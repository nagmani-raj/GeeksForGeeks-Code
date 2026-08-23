class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        java.util.ArrayDeque<Integer> deque = new java.util.ArrayDeque<>();

        dist[r][c] = 0;
        deque.offerFirst(r * m + c);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();

            int x = cur / m;
            int y = cur % m;

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m
                        || mat[nx][ny] == '#') {
                    continue;
                }

                int cost = (nx < x) ? 1 : 0;

                if (dist[nx][ny] > dist[x][y] + cost) {
                    dist[nx][ny] = dist[x][y] + cost;

                    if (cost == 1) {
                        deque.offerLast(nx * m + ny);
                    } else {
                        deque.offerFirst(nx * m + ny);
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '#') {
                    continue;
                }

                int upMoves = dist[i][j];

                if (upMoves > u) {
                    continue;
                }

                int downMoves = (i - r) + upMoves;

                if (downMoves <= d) {
                    ans++;
                }
            }
        }

        return ans;
    }
}