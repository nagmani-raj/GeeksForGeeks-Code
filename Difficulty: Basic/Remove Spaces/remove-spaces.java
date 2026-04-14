class Solution {
    String removeSpaces(String s){
        String result = s.replaceAll("\\s+", "");
        return result;
    }
}