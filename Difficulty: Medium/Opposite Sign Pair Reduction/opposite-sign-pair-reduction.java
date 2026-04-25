class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        
        for (int x : arr) {
            boolean alive = true;
            
            while (!stack.isEmpty() && stack.get(stack.size() - 1) * x < 0) {
                int top = stack.get(stack.size() - 1);
                
                if (Math.abs(top) > Math.abs(x)) {
                    alive = false;
                    break;
                } 
                else if (Math.abs(top) < Math.abs(x)) {
                    stack.remove(stack.size() - 1);
                } 
                else {
                    stack.remove(stack.size() - 1);
                    alive = false;
                    break;
                }
            }
            
            if (alive) {
                stack.add(x);
            }
        }
        
        return stack;
    }
}