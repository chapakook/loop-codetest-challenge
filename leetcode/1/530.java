class Solution {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev != null){
            int diff = node.val - prev;
            if(diff < min) min = diff;
        }
        prev = node.val;
        inorder(node.right);
    }
}