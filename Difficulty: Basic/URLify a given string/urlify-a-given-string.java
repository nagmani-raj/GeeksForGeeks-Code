class Solution {
    String URLify(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) ==' ') {
                result.append("%");
                result.append("2");
                result.append("0");
            } 
            
            
            else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    
    
}