class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] result = new int[n];

        int[] womanPartner = new int[n];

        int[] next = new int[n];

        Arrays.fill(result, -1);
        Arrays.fill(womanPartner, -1);

        int[][] ranking = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                ranking[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][next[m]];
            next[m]++;

            if (womanPartner[w] == -1) {
                womanPartner[w] = m;
                result[m] = w;
            } else {
                int current = womanPartner[w];

                if (ranking[w][m] < ranking[w][current]) {
                    womanPartner[w] = m;
                    result[m] = w;

                    result[current] = -1;
                    freeMen.add(current);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return result;
    }
}