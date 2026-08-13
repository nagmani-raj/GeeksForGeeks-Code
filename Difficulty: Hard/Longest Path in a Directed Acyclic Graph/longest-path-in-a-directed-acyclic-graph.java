class Solution {
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);

            adj.get(u).add(new int[]{v, w});
        }

        int[] indegree = new int[V];

        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                indegree[edge[0]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] edge : adj.get(u)) {
                int v = edge[0];

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = 0;

        for (int u : topo) {
            if (dist[u] == Integer.MIN_VALUE) {
                continue;
            }

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                dist[v] = Math.max(dist[v], dist[u] + w);
            }
        }

        return dist;
    }
}