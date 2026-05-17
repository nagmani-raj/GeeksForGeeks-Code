class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int num : arr) {
            if (!res.isEmpty()) {
                int last = res.get(res.size() - 1);

                if ((last >= 0 && num < 0) || (last < 0 && num >= 0)) {
                    res.remove(res.size() - 1);
                    continue;
                }
            }

            res.add(num);
        }

        return res;
    }
}