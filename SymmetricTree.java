class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return sym(root.left, root.right);
    }
    
    
    private boolean sym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) return false;
        return (left.val == right.val) && sym(left.right, right.left) && sym(left.left, right.right);
    }
}
