class Solution {
    public boolean isBitSet(int n) {
        return n > 0 && (n & (n + 1)) == 0;
    }
}