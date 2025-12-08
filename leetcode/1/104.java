class Solution {
    /**
     * DFS
     * time: O(n)
     * space: O(h)
     */
    public int maxDepthDFS(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * BFS
     * time: O(n)
     * space: O(n)
     */
    public int maxDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            depth++;
        }
        return depth;
    }
}