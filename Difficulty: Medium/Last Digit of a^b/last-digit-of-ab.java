class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) return 1;

        int lastDigit = a.charAt(a.length() - 1) - '0';

        int exp = 0;
        for (char c : b.toCharArray()) {
            exp = (exp * 10 + (c - '0')) % 4;
        }

        if (exp == 0) exp = 4;

        int ans = 1;
        for (int i = 0; i < exp; i++) {
            ans = (ans * lastDigit) % 10;
        }

        return ans;
    }
}