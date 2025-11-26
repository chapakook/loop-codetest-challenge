class Solution {
    /**
     * DFS
     */
    public int minDepthDFS(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    /**
     * BFS
     */
    public int minDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                if(n.left == null && n.right == null) return depth;
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            depth++;
        }
        return depth;
    }
}