class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        long[] prefix = new long[n];
        
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = i / 2;          // median index
            long median = arr[m];

            long leftSum = (m > 0) ? prefix[m - 1] : 0;
            long rightSum = prefix[i] - prefix[m];

            long leftCost = median * m - leftSum;
            long rightCost = rightSum - median * (i - m);

            long cost = leftCost + rightCost;
            ans.add((int) cost);
        }

        return ans;
    }
}