class Solution {

    static class Info {
        int size;
        int min;
        int max;
        boolean isBST;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int maxSize = 0;

    static int largestBst(Node root) {
        maxSize = 0;
        solve(root);
        return maxSize;
    }

    static Info solve(Node root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;

            maxSize = Math.max(maxSize, size);

            return new Info(
                size,
                Math.min(root.data, left.min),
                Math.max(root.data, right.max),
                true
            );
        }

        return new Info(
            Math.max(left.size, right.size),
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            false
        );
    }
}