package PathSum;

public class PathSum
{
    public PathSum()
    {

    }

    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if(root == null) return false;
        return checkHasPathSum(root, targetSum, 0);
    }

    private boolean checkHasPathSum(TreeNode root, int targetSum, int num)
    {
        if(root == null) return false;
        if(root.left == null && root.right == null && num + root.val == targetSum) return true;
        boolean checkLeftNode = checkHasPathSum(root.left, targetSum, num + root.val);
        boolean checkRightNode = checkHasPathSum(root.right, targetSum, num + root.val);
        return checkLeftNode || checkRightNode;
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
