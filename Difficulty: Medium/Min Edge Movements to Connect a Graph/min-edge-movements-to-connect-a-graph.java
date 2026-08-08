 class Solution {
    int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;

        if (m < n - 1) {
            return -1;
        }

        DSU dsu = new DSU(n);
        int extra = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!dsu.union(u, v)) {
                extra++;
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        int needed = components - 1;

        return extra >= needed ? needed : -1;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }
} 