class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] visited = new boolean[V];
        int candidate = -1;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                candidate = i;
            }
        }
        
        Arrays.fill(visited, false);
        dfs(candidate, adj, visited);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        
        for (int i = 0; i < candidate; i++) {
            Arrays.fill(visited, false);
            dfs(i, adj, visited);
            
            boolean allReachable = true;
            for (int j = 0; j < V; j++) {
                if (!visited[j]) {
                    allReachable = false;
                    break;
                }
            }
            
            if (allReachable) {
                return i;
            }
        }
        
        return candidate;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited);
            }
        }
    }
}