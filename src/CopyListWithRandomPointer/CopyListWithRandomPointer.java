package CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer
{
    public CopyListWithRandomPointer()
    {
        Node node = new Node(7);
        Node head = node;
        node.next = new Node(7);
        copyRandomList(head);
    }

    public Node copyRandomList(Node head)
    {
        if(head == null) return head;

        Node resultHead;
        Node nextNode;
        Map<Node, Node> map = new HashMap<>();

        resultHead = new Node(head.val);
        map.put(head, resultHead);
        if(head.random != null)
        {
            if(map.containsKey(head.random))
            {
                resultHead.random = map.get(head.random);
            }
            else
            {
                resultHead.random = new Node(head.random.val);
                map.put(head.random, resultHead.random);
            }
        }
        nextNode = resultHead;
        head = head.next;

        while (head != null)
        {
            if(map.containsKey(head))
            {
                nextNode.next = map.get(head);
            }
            else
            {
                nextNode.next = new Node(head.val);
                map.put(head, nextNode.next);
            }

            nextNode = nextNode.next;

            if(head.random != null)
            {
                if(map.containsKey(head.random))
                {
                    nextNode.random = map.get(head.random);
                }
                else
                {
                    nextNode.random = new Node(head.random.val);
                    map.put(head.random, nextNode.random);
                }
            }

            head = head.next;
        }

        return resultHead;
    }

    // Definition for a Node.
    class Node
    {
        int val;
        Node next;
        Node random;

        public Node(int val)
        {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
