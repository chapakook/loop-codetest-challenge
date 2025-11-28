class Solution {
    /***
     * DP
     */
    public boolean isSameTreeDP(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTreeDP(p.left, q.left) && isSameTreeDP(p.right, q.right);
    }

    /***
     * BFS
     */
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Deque<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[]{p,q});
        while(!queue.isEmpty()){
            TreeNode[] node = queue.poll();
            TreeNode a = node[0];
            TreeNode b = node[1];
            if(a == null && b == null) continue;
            if(a == null || b == null) return false;
            if(a.val != b.val) return false;
            queue.offer(new TreeNode[]{a.left,b.left});
            queue.offer(new TreeNode[]{a.right,b.right});
        }
        return true;
    }
}