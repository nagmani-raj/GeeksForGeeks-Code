class Solution {
    public int validGroups(String s) {
        int n = s.length();
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) - '0');
        }

        Integer[][] memo = new Integer[n][901];

        return solve(0, 0, s, prefix, memo);
    }

    private int solve(int index, int prevSum, String s,
                      int[] prefix, Integer[][] memo) {

        if (index == s.length()) {
            return 1;
        }

        if (memo[index][prevSum] != null) {
            return memo[index][prevSum];
        }

        int count = 0;

        for (int end = index; end < s.length(); end++) {

            int currSum = prefix[end + 1] - prefix[index];

            if (currSum >= prevSum) {
                count += solve(end + 1, currSum, s, prefix, memo);
            }
        }

        memo[index][prevSum] = count;
        return count;
    }
}