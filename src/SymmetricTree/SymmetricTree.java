package SymmetricTree;

public class SymmetricTree
{
    public SymmetricTree()
    {

    }

    public boolean isSymmetric(TreeNode root)
    {
        return checkIsSymmetric(root.left, root.right);
    }

    private boolean checkIsSymmetric(TreeNode left, TreeNode right)
    {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        if(left.left != null && left.right != null && right.left != null && right.right != null && (left.right.val != right.left.val || left.left.val != right.right.val)) return false;

        boolean isLeftNodeSymmetric = checkIsSymmetric(left.left, right.right);
        boolean isRightNodeSymmetric = checkIsSymmetric(right.left, left.right);
        return isLeftNodeSymmetric && isRightNodeSymmetric;

    }

    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
