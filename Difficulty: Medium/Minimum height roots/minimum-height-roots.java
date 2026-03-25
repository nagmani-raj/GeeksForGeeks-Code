import java.util.*;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Edge case
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        // Step 1: Build graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Step 2: Find initial leaves
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }
        
        int remainingNodes = V;
        
        // Step 3: Trim leaves layer by layer
        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    
                    if (graph.get(neighbor).size() == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }
        
        // Step 4: Remaining nodes are centroids
        result.addAll(leaves);
        
        return result;
    }
}