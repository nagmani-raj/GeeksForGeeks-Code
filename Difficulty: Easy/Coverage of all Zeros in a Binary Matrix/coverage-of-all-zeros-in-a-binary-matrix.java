class Solution {
    public int findCoverage(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    
                    // Left
                    for (int c = j - 1; c >= 0; c--) {
                        if (mat[i][c] == 1) {
                            total++;
                            break;
                        }
                    }

                    // Right
                    for (int c = j + 1; c < m; c++) {
                        if (mat[i][c] == 1) {
                            total++;
                            break;
                        }
                    }

                    // Up
                    for (int r = i - 1; r >= 0; r--) {
                        if (mat[r][j] == 1) {
                            total++;
                            break;
                        }
                    }

                    // Down
                    for (int r = i + 1; r < n; r++) {
                        if (mat[r][j] == 1) {
                            total++;
                            break;
                        }
                    }
                }
            }
        }

        return total;
    }
}