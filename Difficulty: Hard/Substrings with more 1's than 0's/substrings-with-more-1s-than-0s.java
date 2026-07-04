import java.util.*;

class Solution {
    public int countSubstring(String s) {
        int n = s.length();

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        int[] vals = prefix.clone();
        Arrays.sort(vals);

        Fenwick bit = new Fenwick(n + 2);

        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(vals, x) + 1;

            // Count previous prefix sums strictly smaller than x
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return (int) ans;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}