class Solution {
    public int visibleBuildings(int arr[]) {
        int n = arr.length;
        int count = 1;
        
        int k = arr[0];
        
        if(n == 0) return 0;
        
        for(int i=1; i<n; i++){
            if(arr[i] >= k){
                count++;
                k = arr[i];
            }
        }
        
        return count;
    }
}


