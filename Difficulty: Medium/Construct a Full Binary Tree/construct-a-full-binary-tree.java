/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    Node build(int[] pre, int[] preMirror, int l, int h) {

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == h || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);

        if (idx >= l && idx <= h) {
            root.left = build(pre, preMirror, idx, h);
            root.right = build(pre, preMirror, l + 1, idx - 1);
        }

        return root;
    }

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        preIndex = 0;
        return build(pre, preMirror, 0, preMirror.length - 1);
    }
}