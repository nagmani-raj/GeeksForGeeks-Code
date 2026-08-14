class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) {
            return true;
        }

        long sum = s;
        ArrayList<Long> seq = new ArrayList<>();

        seq.add((long) s);

        for (int a : arr) {
            long next = sum + a;

            if (next > x) {
                break;
            }

            seq.add(next);

            sum += next;
        }

        long target = x;

        for (int i = seq.size() - 1; i >= 0; i--) {
            if (seq.get(i) <= target) {
                target -= seq.get(i);
            }

            if (target == 0) {
                return true;
            }
        }

        return false;
    }
}