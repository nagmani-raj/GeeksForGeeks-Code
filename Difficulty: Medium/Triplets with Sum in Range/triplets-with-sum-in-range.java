

class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        return countLessEqual(arr, r) - countLessEqual(arr, l - 1);
    }

    private int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        java.util.Arrays.sort(arr);

        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= x) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) count;
    }
}