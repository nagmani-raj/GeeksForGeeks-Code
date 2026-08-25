class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < n; i++) {

            if (pos[i] < pos[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            maxCount = Math.max(maxCount, count);
        }

        return n - maxCount;
    }
}