class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; i++){
                TreeNode n = q.poll();
                list.add(n.val);
                if(n.left != null) q.offer(n.left);
                if(n.right != null) q.offer(n.right);
            }
            ans.add(list);
        }
        return ans;
    }
}