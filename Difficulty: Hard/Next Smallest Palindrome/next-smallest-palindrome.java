class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        boolean all9 = true;
        for (int i = 0; i < n; i++) {
            if (num[i] != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] result = num.clone();

        int i = 0, j = n - 1;
        while (i < j) {
            result[j] = result[i];
            i++;
            j--;
        }

        boolean isGreater = false;
        for (int k = 0; k < n; k++) {
            if (result[k] > num[k]) {
                isGreater = true;
                break;
            } else if (result[k] < num[k]) {
                break;
            }
        }

        if (isGreater) return result;

        int carry = 1;
        int mid = n / 2;

        if (n % 2 == 1) {
            result[mid] += carry;
            carry = result[mid] / 10;
            result[mid] %= 10;
            i = mid - 1;
            j = mid + 1;
        } else {
            i = mid - 1;
            j = mid;
        }

        while (i >= 0 && carry > 0) {
            result[i] += carry;
            carry = result[i] / 10;
            result[i] %= 10;

            result[j] = result[i]; 
            i--;
            j++;
        }

       while (i >= 0) {
            result[j] = result[i];
            i--;
            j++;
        }

        return result;
    }
}