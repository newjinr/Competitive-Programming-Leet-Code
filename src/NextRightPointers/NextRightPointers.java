package NextRightPointers;

import java.util.HashMap;
import java.util.Map;

public class NextRightPointers
{
    private Map<Integer, Node> nodeLevel = new HashMap<>();

    public NextRightPointers()
    {

    }

    public Node connect(Node root)
    {
        connectNode(root, 0);
        nodeLevel.clear();
        return root;
    }

    public void connectNode(Node root, int i)
    {
        if(root == null) return;

        if(!nodeLevel.containsKey(i))
            nodeLevel.put(i, root);
        else
        {
            nodeLevel.get(i).next = root;
            nodeLevel.put(i, root);
        }
        i++;
        connectNode(root.left, i);
        connectNode(root.right, i);
    }

    class Node
    {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val)
        {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
