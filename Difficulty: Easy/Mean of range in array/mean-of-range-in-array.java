class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr .length;
        int k = queries.length;
        
        ArrayList<Integer> arrl = new ArrayList<>();
        
        int[] pre = new int[n];
        pre[0] = arr[0];
        
        for(int i=1; i<n; i++){
            pre[i] = arr[i] + pre[i-1];
        }
        
        for(int i=0; i<k; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            
            int sum ;
            
            if(l == 0){
                sum = pre[r];
            }else{
                sum = pre[r] - pre[l-1];
            }
            
            int len = r-l+1;
            
            int mean = sum/len;
            
            arrl.add(mean);
        }
        
        return arrl;
    }
}