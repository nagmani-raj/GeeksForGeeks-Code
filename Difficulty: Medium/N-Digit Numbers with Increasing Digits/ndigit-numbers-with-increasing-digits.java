class Solution {
    
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }
        
        if (n > 10) return ans;
        
        generate(n, 1, 0, 0, ans);
        return ans;
    }
    
    private static void generate(int n, int start, int len, int num,
                                 ArrayList<Integer> ans) {
        
        if (len == n) {
            ans.add(num);
            return;
        }
        
        for (int digit = start; digit <= 9; digit++) {
            generate(n, digit + 1, len + 1, num * 10 + digit, ans);
        }
    }
}