class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int noTask = 0;
        int low = l[0];
        int high = h[0];

        for (int i = 1; i < n; i++) {
            int newNoTask = Math.max(noTask, Math.max(low, high));

            int newLow = Math.max(noTask, Math.max(low, high)) + l[i];

            int newHigh = noTask + h[i];

            noTask = newNoTask;
            low = newLow;
            high = newHigh;
        }

        return Math.max(noTask, Math.max(low, high));
    }
}