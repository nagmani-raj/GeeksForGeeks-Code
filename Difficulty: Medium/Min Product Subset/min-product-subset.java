class Solution {
    public int minProd(int[] arr) {
        int negCount = 0;
        int largestNeg = Integer.MIN_VALUE;
        int product = 1;
        boolean hasPositive = false;
        boolean hasZero = false;

        for (int x : arr) {
            if (x < 0) {
                negCount++;
                largestNeg = Math.max(largestNeg, x);
            } else if (x == 0) {
                hasZero = true;
            } else {
                hasPositive = true;
            }
        }

        // No negative numbers
        if (negCount == 0) {
            if (hasZero) return 0;

            int min = Integer.MAX_VALUE;
            for (int x : arr) {
                min = Math.min(min, x);
            }
            return min;
        }

        // Multiply all negatives
        for (int x : arr) {
            if (x < 0) {
                product *= x;
            }
        }

        if (negCount % 2 == 0) {
            product /= largestNeg;
        }

        // Multiply all positive numbers
        for (int x : arr) {
            if (x > 0) {
                product *= x;
            }
        }

        return product;
    }
}