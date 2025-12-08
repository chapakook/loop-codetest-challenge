class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;
        int target = targetSum - root.val;
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }
}