class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int cur = -1;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < groups.length; i++){
            if(cur == groups[i]) continue;
            cur = groups[i];
            ans.add(words[i]);
        }
        return ans;
    }
}