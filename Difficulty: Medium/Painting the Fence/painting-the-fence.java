class Solution {
    int countWays(int n, int k) {
        if (n == 1) return k;
        
        int same = 0;
        int diff = k;
        int total = k;
        
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }
        
        return total;
    }
}