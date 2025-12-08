class Solution {
    public int maxRepeating(String sequence, String word) {
        int n1 = sequence.length(), n2 = word.length();
        if (n1 < n2) return 0;
        int[] dp = new int[n1];
        int ans = 0;
        for (int i = 0; i < n1; i++) {
            if (i + 1 >= n2) {
                boolean match = true;
                int start = i - n2 + 1;
                for (int j = 0; j < n2; j++) {
                    if (sequence.charAt(start + j) != word.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    dp[i] = (i >= n2 ? dp[i - n2] : 0) + 1;
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}