class Solution {

    boolean path(int[][] arr, int n, int[][] visited, boolean[][] dead,
                 int i, int j) {

        if (i == n - 1 && j == n - 1) {
            visited[i][j] = 1;
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= n ||
            arr[i][j] == 0 || dead[i][j] || visited[i][j] == 1) {
            return false;
        }

        visited[i][j] = 1;

        int m = arr[i][j];

        for (int temp = 1; temp <= m; temp++) {

            // right first
            if (path(arr, n, visited, dead, i, j + temp))
                return true;

            // down
            if (path(arr, n, visited, dead, i + temp, j))
                return true;
        }

        visited[i][j] = 0;
        dead[i][j] = true;   // important optimization

        return false;
    }

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {

        int n = mat.length;

        int[][] visited = new int[n][n];
        boolean[][] dead = new boolean[n][n];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (!path(mat, n, visited, dead, 0, 0)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            ans.add(temp);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(visited[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }
}