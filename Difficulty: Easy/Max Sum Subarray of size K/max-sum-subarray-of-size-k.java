class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        
        for(int i=0 ; i<k; i++){
            sum += arr[i];
        }
        
        int maxsum = sum;
        
        for(int i=k; i<n; i++){
            sum += arr[i] - arr[i-k];
            
            maxsum = Math.max(maxsum, sum);
        }
        
        return maxsum;
        
    }
}