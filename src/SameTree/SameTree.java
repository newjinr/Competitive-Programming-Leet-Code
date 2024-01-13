package SameTree;

public class SameTree
{
    public SameTree()
    {

    }

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null && q != null || p != null && q == null) return false;
        if(p != null & q != null && p.val != q.val) return false;

        if(p != null && q != null)
        {
            boolean isSameOnleft = !isSameTree(p.left, q.left);
            boolean isSameOnRight = !isSameTree(p.right, q.right);

            return !isSameOnleft && !isSameOnRight;
        }

        return true;
    }

    class TreeNode
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
