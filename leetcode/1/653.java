class Solution {
    /** HashSet */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return ft(root, k, s);
    }
    private boolean ft(TreeNode n, int k, Set<Integer> s) {
        if(n == null) return false;
        int t = k - n.val;
        if(s.contains(t)) return true;
        s.add(n.val);
        return ft(n.left,k,s) || ft(n.right,k,s);
    }

    /** Inorder + Two Pointers */
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> ns = new ArrayList<>();
        inorder(root, ns);
        int l = 0;
        int r = ns.size() - 1;
        while(l < r){
            int s = ns.get(l) + ns.get(r);
            if(s == k) return true;
            if(s < k) l++;
            else r--;
        }
        return false;
    }
    private void inorder(TreeNode n, List<Integer> ns) {
        if(n == null) return;
        inorder(n.left, ns);
        ns.add(n.val);
        inorder(n.right, ns);
    }
}