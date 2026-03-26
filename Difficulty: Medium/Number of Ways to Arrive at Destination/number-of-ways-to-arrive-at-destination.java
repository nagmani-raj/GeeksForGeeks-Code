
class Solution {
    static int countPaths(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        long[] ways = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            int node = (int) top[0];
            long d = top[1];
            if (d > dist[node]) continue;
            
            for (int[] nxt : graph.get(node)) {
                int v = nxt[0];
                long wt = nxt[1];
                if (dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                    ways[v] = ways[node];
                    pq.add(new long[]{v, dist[v]});
                } else if (dist[node] + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[node]);
                }
            }
        }
        return (int) ways[V - 1];
    }
}
