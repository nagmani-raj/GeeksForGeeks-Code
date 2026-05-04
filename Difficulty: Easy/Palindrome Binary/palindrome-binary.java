class Solution {
    public boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);
        
        int i = 0, j = binary.length() - 1;
        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}