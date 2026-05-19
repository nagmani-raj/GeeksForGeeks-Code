import java.util.*;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        
        int[] dist = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int steps = curr[1];
            
            if (node == end) {
                return steps;
            }
            
            for (int num : arr) {
                int newVal = (node * num) % 1000;
                
                if (steps + 1 < dist[newVal]) {
                    dist[newVal] = steps + 1;
                    q.offer(new int[]{newVal, steps + 1});
                }
            }
        }
        
        return -1;
    }
}