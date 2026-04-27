class Solution {
    public int smallestSubstring(String s) {
        int[] count = new int[3];
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            // current character ka count badhao
            count[s.charAt(right) - '0']++;

            // jab tak 0,1,2 teeno present ho
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                }

                // left ko aage badhao (window chhota karo)
                count[s.charAt(left) - '0']--;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1;
        return minLen;
    }
}