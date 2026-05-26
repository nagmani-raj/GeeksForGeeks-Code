class Solution {
    int minToggle(int[] arr) {
        int n = arr.length;

        int[] prefixOnes = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (arr[i] == 1 ? 1 : 0);
        }

        int totalOnes = prefixOnes[n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            int leftToggles = prefixOnes[i];

            int rightZeros = (n - i) - (totalOnes - prefixOnes[i]);

            ans = Math.min(ans, leftToggles + rightZeros);
        }

        return ans;
    }
}