class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();

        long[] pow = new long[len + 1];
        pow[0] = 1;

        for (int i = 1; i <= len; i++) {
            pow[i] = pow[i - 1] * (10 - 1);
        }

        long ans = 0;

        for (int digits = 1; digits < len; digits++) {
            int choices = (d == 0) ? 9 : 9;

            if (d != 0) {
                choices = 8;
            }

            ans += choices * pow[digits - 1];
        }

        for (int i = 0; i < len; i++) {
            int current = s.charAt(i) - '0';

            int smaller = 0;

            for (int digit = 0; digit < current; digit++) {
                if (digit == d) {
                    continue;
                }

                if (i == 0 && digit == 0) {
                    continue;
                }

                smaller++;
            }

            ans += smaller * pow[len - i - 1];

            if (current == d) {
                return (int) ans;
            }
        }

        return (int) (ans + 1);
    }
}