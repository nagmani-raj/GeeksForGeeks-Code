class Solution {
    public int countMinOperations(int[] arr) {
        int ans = 0;

        while (true) {

            boolean allZero = true;

            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & 1) == 1) {
                    arr[i]--;
                    ans++;
                }

                if (arr[i] != 0)
                    allZero = false;
            }

            if (allZero)
                break;

            for (int i = 0; i < arr.length; i++)
                arr[i] /= 2;

            ans++;
        }

        return ans;
    }
}