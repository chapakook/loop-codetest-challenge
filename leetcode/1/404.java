class Solution {
    /**
     * DFS
     */
    public int sumOfLeftLeavesDFS(TreeNode root) {
        return dfs(root, false);
    }
    private int dfs(TreeNode n , boolean b){
        if(n == null) return 0;
        if(n.left == null && n.right == null) return b ? n.val : 0;
        int l = dfs(n.left, true);
        int r = dfs(n.right, false);
        return l+r;
    }
    /**
     * BFS
     */
    public int sumOfLeftLeavesBFS(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(
            root.left != null &&
            root.left.left == null &&
            root.left.right == null
        ){
            ans += root.left.val;
        }
        ans += sumOfLeftLeaves(root.left);
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}