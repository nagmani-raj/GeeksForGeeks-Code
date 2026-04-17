class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        
        
        int oddcount = 0;
        
        for(int count : freq){
            if(count%2 != 0){
                oddcount++;
            }
        }
        
        return oddcount <= 1;
        
    }
}