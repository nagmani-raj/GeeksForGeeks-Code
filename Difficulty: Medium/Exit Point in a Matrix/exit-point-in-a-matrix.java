class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0, col = 0;
        int dir = 0; 

        while (true) {

            if (mat[row][col] == 1) {
                dir = (dir + 1) % 4;
                mat[row][col] = 0;
            }

            if (dir == 0) {
                col++;
            } else if (dir == 1) {
                row++;
            } else if (dir == 2) {
                col--;
            } else {
                row--;
            }

            if (row < 0) {
                row++;
                break;
            }
            if (row >= n) {
                row--;
                break;
            }
            if (col < 0) {
                col++;
                break;
            }
            if (col >= m) {
                col--;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(row);
        ans.add(col);

        return ans;
    }
}