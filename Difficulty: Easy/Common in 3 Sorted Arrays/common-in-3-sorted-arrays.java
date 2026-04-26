class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            
            if (a[i] == b[j] && b[j] == c[k]) {
                if (arr.size() == 0 || arr.get(arr.size()-1) != a[i]) {
                    arr.add(a[i]);
                }
                i++; j++; k++;
            }
            else {
                if (a[i] <= b[j] && a[i] <= c[k]) {
                    i++;
                } else if (b[j] <= a[i] && b[j] <= c[k]) {
                    j++;
                } else {
                    k++;
                }
            }
        }
        
        return arr;
    }
}