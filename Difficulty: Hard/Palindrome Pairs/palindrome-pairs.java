import java.util.*;

class Solution {
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public boolean palindromePair(String[] arr) {  // ✅ Fixed name
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            int n = word.length();
            
            for (int j = 0; j <= n; j++) {
                if (isPalindrome(word, 0, j - 1)) {
                    String rightReversed = reverse(word.substring(j));
                    if (map.containsKey(rightReversed)) {
                        int idx = map.get(rightReversed);
                        if (idx != i) return true;
                    }
                }
                
                if (j != n && isPalindrome(word, j, n - 1)) {
                    String leftReversed = reverse(word.substring(0, j));
                    if (map.containsKey(leftReversed)) {
                        int idx = map.get(leftReversed);
                        if (idx != i) return true;
                    }
                }
            }
        }
        
        return false;
    }
}