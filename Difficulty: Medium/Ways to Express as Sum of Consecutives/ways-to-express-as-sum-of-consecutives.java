class Solution {
    public int getCount(int n) {
        int count = 0;

        for (int k = 2; (long) k * (k + 1) / 2 <= n; k++) {
            long rem = (long) n - (long) k * (k - 1) / 2;
            if (rem > 0 && rem % k == 0) {
                count++;
            }
        }

        return count;
    }
}