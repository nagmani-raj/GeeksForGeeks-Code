class Solution {
    
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        // Store indices of each value
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            if (!map.containsKey(x)) {
                ans.add(0);
                continue;
            }
            
            ArrayList<Integer> pos = map.get(x);
            
            int left = lowerBound(pos, l);      // first index >= l
            int right = upperBound(pos, r);     // first index > r
            
            ans.add(right - left);
        }
        
        return ans;
    }
    
    private int lowerBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (list.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
    
    private int upperBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (list.get(mid) <= target)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
}