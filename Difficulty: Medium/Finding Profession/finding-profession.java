class Solution {
    public String profession(int level, int pos) {
        int count = Integer.bitCount(pos - 1);
        return (count % 2 == 0) ? "Engineer" : "Doctor";
    }
}