class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<>();
        result.add(null); // Index 0: Predecessor
        result.add(null); // Index 1: Successor
        
        Node curr = root;
        
        // Find Predecessor
        Node pre = null;
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        result.set(0, pre);
        
        // Reset for Successor
        curr = root;
        Node suc = null;
        while (curr != null) {
            if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        result.set(1, suc);
        
        return result;
    }
}