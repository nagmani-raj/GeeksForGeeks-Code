import java.util.*;

class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; // start from house 0
        
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            
            // Pick the unvisited node with minimum distance
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            
            visited[u] = true;
            totalCost += minDist[u];
            
            // Update distances
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int cost = Math.abs(houses[u][0] - houses[v][0]) +
                               Math.abs(houses[u][1] - houses[v][1]);
                    
                    minDist[v] = Math.min(minDist[v], cost);
                }
            }
        }
        
        return totalCost;
    }
}