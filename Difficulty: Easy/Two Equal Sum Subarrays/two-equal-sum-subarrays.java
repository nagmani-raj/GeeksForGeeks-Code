class Solution {
    public boolean canSplit(int arr[]) {
        // Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        if(sum % 2 != 0) return false;
        
        int ans = sum/2;
        sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == ans) return true;
        }
        
        return false;
    }
}