class Solution {
    /** DFS */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /** BFS */
    public TreeNode mergeTreesBFS(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        Deque<TreeNode[]> q = new ArrayDeque<>();
        q.offer(new TreeNode[]{root1, root2});
        while(!q.isEmpty()){
            TreeNode[] pair = q.poll();
            TreeNode t1 = pair[0];
            TreeNode t2 = pair[1];
            t1.val += t2.val;
            if(t1.left == null) t1.left = t2.left;
            else if(t2.left != null)q.offer(new TreeNode[]{t1.left, t2.left});
            if(t1.right == null) t1.right = t2.right;
            else if(t2.right != null) q.offer(new TreeNode[]{t1.right, t2.right});
        }
        return root1;
    }
}