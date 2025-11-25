class Solution {
    /**
     * DFS
     * time: O(n)
     * space: O(h)
     */
    public boolean isSymmetricDFS(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    /**
     * BFS
     * time: O(n)
     * space: O(n)
     */
    public boolean isSymmetricBFS(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}
