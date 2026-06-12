import java.util.*;

class Solution {
    public boolean kSubstr(String s, int k) {

        int n = s.length();

        if (n % k != 0) return false;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i += k) {
            String block = s.substring(i, i + k);
            map.put(block, map.getOrDefault(block, 0) + 1);
        }

        int blocks = n / k;

        if (map.size() == 1) return true;

        if (map.size() > 2) return false;

        for (int freq : map.values()) {
            if (freq == 1) return true;
        }

        return false;
    }
}