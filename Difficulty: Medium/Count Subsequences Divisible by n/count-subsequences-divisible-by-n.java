class Solution {
    public int countSubsequences(String s, int n) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            long[] next = dp.clone();

            int rem = digit % n;
            next[rem] = (next[rem] + 1) % MOD;

            for (int r = 0; r < n; r++) {
                if (dp[r] != 0) {
                    int newRem = (r * 10 + digit) % n;
                    next[newRem] = (next[newRem] + dp[r]) % MOD;
                }
            }

            dp = next;
        }

        return (int) dp[0];
    }
}