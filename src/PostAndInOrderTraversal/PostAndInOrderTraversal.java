package PostAndInOrderTraversal;

public class PostAndInOrderTraversal
{
    int i = 0;
    int j = 0;

    public PostAndInOrderTraversal()
    {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        i = postorder.length - 1;
        j = i;
        return build(inorder, postorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] inorder, int[] postorder, int stop)
    {
        if(i < 0) return null;

        if(inorder[j] == stop)
        {
            j--;
            return null;
        }

        TreeNode node = new TreeNode(postorder[i--]);
        node.right = build(inorder, postorder, node.val);
        node.left = build(inorder, postorder, stop);

        return node;
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
