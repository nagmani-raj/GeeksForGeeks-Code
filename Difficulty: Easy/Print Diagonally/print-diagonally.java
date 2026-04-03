import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = mat.length;

        for(int d = 0; d < 2*n - 1; d++) {

            int row = (d < n) ? 0 : d - n + 1;
            int col = (d < n) ? d : n - 1;

            while(row < n && col >= 0) {
                ans.add(mat[row][col]);
                row++;
                col--;
            }
        }
        return ans;
    }
}