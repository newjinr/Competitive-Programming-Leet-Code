package PreAndInOrderTraversal;

public class PreAndInOrderTraversal
{
    private int i = 0;
    private int p = 0;

    public PreAndInOrderTraversal()
    {
        int[] preOrder = new int[]{1,2,4,5,3,6,7,8,9};
        int[] inOrder = new int[]{4,2,5,1,6,3,8,7,9};

        buildTree(preOrder, inOrder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop)
    {
        if (p >= preorder.length)
            return null;

        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
