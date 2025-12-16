class Solution {
    public int maxProfit(int[] prices) {
        int min = 100001;
        int max = 0;
        for(int p: prices) {
            if(p < min) min = p;
            else {
                int r = p - min;
                if(r > max) max = r;
            }
        }
        return max;
    }
}