class Solution {
    int countStrings(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;
        
        int a = 2, b = 3, c = 0;
        
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return b;
    }
}