class Solution {
    static final long MOD = 1000000007L;

    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        long ans = 1;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = 0;
                int cur = i;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1; 
                    len++;
                }

                ans = lcm(ans, len);
            }
        }

        return (int) (ans % MOD);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}