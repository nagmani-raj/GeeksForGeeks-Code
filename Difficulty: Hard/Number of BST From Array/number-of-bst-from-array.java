import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }
            
            int ways = dp[left] * dp[right];
            result.add(ways);
        }
        
        return result;
    }
}