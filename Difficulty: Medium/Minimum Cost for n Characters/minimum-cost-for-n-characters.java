class Solution {
    public int minCost(int n, int i, int d, int c) {
        long ans = (long) n * i;

        while (n > 1) {
            if (n % 2 == 0) {
                ans = Math.min(ans, c + minCost(n / 2, i, d, c));
            } else {
                ans = Math.min(ans, i + minCost(n - 1, i, d, c));
                ans = Math.min(ans, d + minCost(n + 1, i, d, c));
            }
            break;
        }

        return (int) ans;
    }
}