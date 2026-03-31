class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        
        int hold = -arr[0]; // buying on first day
        int cash = 0;       // no stock, no profit
        
        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, cash - arr[i]);
            int newCash = Math.max(cash, hold + arr[i] - k);
            
            hold = newHold;
            cash = newCash;
        }
        
        return cash;
    }
}