import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {
            return Integer.bitCount(b) - Integer.bitCount(a);
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : temp) {
            result.add(num);
        }

        return result;
    }
}